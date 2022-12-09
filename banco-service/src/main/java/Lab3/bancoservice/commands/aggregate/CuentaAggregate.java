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
    private double saldo;

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
}
