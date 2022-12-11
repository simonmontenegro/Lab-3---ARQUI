package Lab3.bancoservice.commands.events;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CuentaCreatedEvent {

    private String id;
    private int saldo;
    private String nombre_persona;
}
