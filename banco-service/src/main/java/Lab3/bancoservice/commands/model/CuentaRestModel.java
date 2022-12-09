package Lab3.bancoservice.commands.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
public class CuentaRestModel {
    private double saldo;
}
