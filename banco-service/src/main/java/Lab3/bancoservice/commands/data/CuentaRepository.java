package Lab3.bancoservice.commands.data;

import org.springframework.data.jpa.repository.*;

import java.util.*;

public interface CuentaRepository extends JpaRepository<Cuenta, String> {
}
