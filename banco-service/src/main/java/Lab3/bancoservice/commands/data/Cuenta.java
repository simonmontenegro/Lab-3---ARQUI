package Lab3.bancoservice.commands.data;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.*;

@Data
@Entity
public class Cuenta {
    @Id
    private String id;
    private double saldo;
}
