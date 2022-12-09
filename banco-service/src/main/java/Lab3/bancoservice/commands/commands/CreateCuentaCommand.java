package Lab3.bancoservice.commands.commands;

import lombok.*;
import org.axonframework.modelling.command.*;

@Data
@Builder
public class CreateCuentaCommand {

    @TargetAggregateIdentifier
    private String id;
    private double saldo;

}
