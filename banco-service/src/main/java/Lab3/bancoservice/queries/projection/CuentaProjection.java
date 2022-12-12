package Lab3.bancoservice.queries.projection;

import Lab3.bancoservice.commands.data.*;
import Lab3.bancoservice.commands.model.*;
import Lab3.bancoservice.queries.queries.*;
import org.axonframework.queryhandling.*;
import org.springframework.stereotype.*;

import java.text.*;
import java.util.*;
import java.util.stream.*;

@Component
public class CuentaProjection {
    private CuentaRepository cuentaRepository;

    public CuentaProjection(CuentaRepository cuentaRepository){
        this.cuentaRepository = cuentaRepository;
    }

    @QueryHandler
    public List<CuentaRestModel> handle(GetCuentasQuery getCuentasQuery){
        List<Cuenta> cuentas = cuentaRepository.findAll();

        List<CuentaRestModel> cuentaRestModels =
                cuentas.stream()
                    .map(cuenta -> CuentaRestModel
                            .builder()
                            .id(cuenta.getId())
                            .saldo(cuenta.getSaldo())
                            .nombre_persona(cuenta.getNombre_persona())
                            .build())
                    .collect(Collectors.toList());
        return cuentaRestModels;
    }

    @QueryHandler
    public String handle(GetSaldoQuery getSaldoQuery){
        Cuenta cuenta = cuentaRepository.findById(getSaldoQuery.getId()).orElseThrow();

        NumberFormat CLPformatter = NumberFormat.getCurrencyInstance();
        String resultado = CLPformatter.format(cuenta.getSaldo());

        //Le quito el simbolo raro
        resultado = resultado.substring(1);

        //Quito el punto decimal
        int largo = resultado.length();
        resultado = resultado.substring(0, largo-3);

        //Cambio comas por punto
        resultado = resultado.replaceAll(",", ".");

        //Agrego signo peso
        resultado = "$ " + resultado;
        
        return resultado;
    }
}
