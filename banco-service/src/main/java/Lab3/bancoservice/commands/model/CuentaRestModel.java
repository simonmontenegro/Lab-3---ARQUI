package Lab3.bancoservice.commands.model;

import lombok.*;

@Data
@Builder
public class CuentaRestModel {
    private String id;
    private int saldo;
    private String nombre_persona;
}
