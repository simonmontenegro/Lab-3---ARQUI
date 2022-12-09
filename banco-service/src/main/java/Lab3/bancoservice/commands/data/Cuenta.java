package Lab3.bancoservice.commands.data;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
public class Cuenta {
    @Id
    private String id;
    private double saldo;
}
