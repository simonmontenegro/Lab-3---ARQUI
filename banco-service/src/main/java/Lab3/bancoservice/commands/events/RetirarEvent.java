package Lab3.bancoservice.commands.events;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RetirarEvent {
    private String id;
    private int monto;
    private String nombre_persona;
}
