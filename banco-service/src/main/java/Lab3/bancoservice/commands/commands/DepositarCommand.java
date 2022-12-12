package Lab3.bancoservice.commands.commands;

import lombok.*;
import org.axonframework.modelling.command.*;

@Data
@Builder
public class DepositarCommand {
    @TargetAggregateIdentifier
    private String id;
    private int monto;
    private String nombre_persona;
}
