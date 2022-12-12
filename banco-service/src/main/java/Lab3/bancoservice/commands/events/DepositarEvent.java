package Lab3.bancoservice.commands.events;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DepositarEvent {
    private String id;
    private int monto;
    private String nombre_persona;
}
