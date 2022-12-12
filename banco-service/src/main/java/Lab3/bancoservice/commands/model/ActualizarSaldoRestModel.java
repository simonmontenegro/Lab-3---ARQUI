package Lab3.bancoservice.commands.model;

import lombok.*;

@Data
@Builder
public class ActualizarSaldoRestModel {
    private String id;
    private int monto;
    private String nombre_persona;
}
