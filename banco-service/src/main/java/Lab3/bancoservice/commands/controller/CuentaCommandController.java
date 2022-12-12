package Lab3.bancoservice.commands.controller;

import Lab3.bancoservice.commands.commands.*;
import Lab3.bancoservice.commands.model.*;
import org.axonframework.commandhandling.gateway.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/cuenta")
public class CuentaCommandController {

    private CommandGateway commandGateway;

    public CuentaCommandController(CommandGateway commandGateway){
        this.commandGateway = commandGateway;
    }

    @PostMapping
    public String addCuenta(@RequestBody CuentaRestModel cuentaRestModel){

        CreateCuentaCommand createCuentaCommand =
                CreateCuentaCommand.builder()
                    .id(UUID.randomUUID().toString())
                    .saldo(cuentaRestModel.getSaldo())
                    .nombre_persona(cuentaRestModel.getNombre_persona())
                    .build();
        String result = commandGateway.sendAndWait(createCuentaCommand);
        return result;
    }

    @PutMapping("/depositar/{id}")
    public String depositarCuenta(@RequestBody ActualizarSaldoRestModel actualizarSaldoRestModel, @PathVariable("id") String id) {

        DepositarCommand actualizarSaldoCommand =
                DepositarCommand.builder()
                        .id(id)
                        .monto(actualizarSaldoRestModel.getMonto())
                        .nombre_persona(actualizarSaldoRestModel.getNombre_persona())
                        .build();
        String result = commandGateway.sendAndWait(actualizarSaldoCommand);

        return result;
    }

    @PutMapping("/retirar/{id}")
    public String retirarCuenta(@RequestBody ActualizarSaldoRestModel actualizarSaldoRestModel, @PathVariable("id") String id) {

        RetirarCommand actualizarSaldoCommand =
                RetirarCommand.builder()
                        .id(id)
                        .monto(actualizarSaldoRestModel.getMonto())
                        .nombre_persona(actualizarSaldoRestModel.getNombre_persona())
                        .build();
        String result = commandGateway.sendAndWait(actualizarSaldoCommand);
        return result;
    }
}
