package Lab3.bancoservice.commands.aggregate;

import Lab3.bancoservice.commands.commands.*;
import Lab3.bancoservice.commands.data.*;
import Lab3.bancoservice.commands.events.*;
import org.axonframework.commandhandling.*;
import org.axonframework.eventsourcing.*;
import org.axonframework.modelling.command.*;
import org.axonframework.spring.stereotype.*;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.*;

@Aggregate
public class CuentaAggregate {

    @AggregateIdentifier
    private String id;
    private int saldo;
    private String nombre_persona;

    public CuentaAggregate(){

    }

    @CommandHandler
    public CuentaAggregate(CreateCuentaCommand createCuentaCommand){
        CuentaCreatedEvent cuentaCreatedEvent = new CuentaCreatedEvent();

        BeanUtils.copyProperties(createCuentaCommand, cuentaCreatedEvent);

        AggregateLifecycle.apply(cuentaCreatedEvent);
    }

    @EventSourcingHandler
    public void on(CuentaCreatedEvent cuentaCreatedEvent){
        this.id = cuentaCreatedEvent.getId();
        this.saldo = cuentaCreatedEvent.getSaldo();
    }

    //Depositar
    @CommandHandler
    public void cuentaAggregate(DepositarCommand depositarCommand){
        DepositarEvent depositarEvent = new DepositarEvent();

        BeanUtils.copyProperties(depositarCommand, depositarEvent);

        AggregateLifecycle.apply(depositarEvent);
    }

    @EventSourcingHandler
    public void on(DepositarEvent depositarEvent){
        this.id = depositarEvent.getId();
        this.saldo = this.saldo + depositarEvent.getMonto();
        this.nombre_persona = depositarEvent.getNombre_persona();
    }

    //Retirar
    @CommandHandler
    public void cuentaAggregate(RetirarCommand retirarCommand){
        if(this.saldo - retirarCommand.getMonto() < 0){
            System.out.println("No es posible retirar dicha cantidad de dinero, intente con un monto inferior");
        }
        else{
            RetirarEvent retirarEvent = new RetirarEvent();

            BeanUtils.copyProperties(retirarCommand, retirarEvent);

            AggregateLifecycle.apply(retirarEvent);
        }

    }

    @EventSourcingHandler
    public void on(RetirarEvent retirarEvent){
        this.id = retirarEvent.getId();
        this.saldo = this.saldo - retirarEvent.getMonto();
        this.nombre_persona = retirarEvent.getNombre_persona();
    }
}
