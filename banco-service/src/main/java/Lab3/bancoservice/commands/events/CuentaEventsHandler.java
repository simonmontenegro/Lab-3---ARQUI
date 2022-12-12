package Lab3.bancoservice.commands.events;

import Lab3.bancoservice.commands.data.*;
import Lab3.bancoservice.commands.model.*;
import com.fasterxml.jackson.databind.util.*;
import org.axonframework.config.*;
import org.axonframework.eventhandling.*;
import org.springframework.beans.*;
import org.springframework.stereotype.*;
import org.springframework.stereotype.Component;

@Component
@ProcessingGroup("cuenta")
public class CuentaEventsHandler {
    private CuentaRepository cuentaRepository;

    public CuentaEventsHandler(CuentaRepository cuentaRepository){
        this.cuentaRepository = cuentaRepository;
    }

    @EventHandler
    public void on(CuentaCreatedEvent event){
        Cuenta cuenta = new Cuenta();
        BeanUtils.copyProperties(event, cuenta);
        cuentaRepository.save(cuenta);
    }

    //Depositar
    @EventHandler
    public void on(DepositarEvent event)  {
        Cuenta cuenta = cuentaRepository.findById(event.getId()).orElseThrow();
        cuenta.setSaldo(cuenta.getSaldo() + event.getMonto());
    }

    //Retirar
    @EventHandler
    public void on(RetirarEvent event)  {
        Cuenta cuenta = cuentaRepository.findById(event.getId()).orElseThrow();
        cuenta.setSaldo(cuenta.getSaldo() - event.getMonto());
    }
}
