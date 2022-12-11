package Lab3.bancoservice.commands.data;

import org.springframework.data.jpa.repository.*;

public interface CuentaRepository extends JpaRepository<Cuenta, String> {
}
