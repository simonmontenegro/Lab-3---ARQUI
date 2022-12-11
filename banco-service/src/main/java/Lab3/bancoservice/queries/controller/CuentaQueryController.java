package Lab3.bancoservice.queries.controller;

import Lab3.bancoservice.commands.model.*;
import Lab3.bancoservice.queries.queries.*;
import org.axonframework.messaging.responsetypes.*;
import org.axonframework.queryhandling.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/cuenta")
public class CuentaQueryController {
    private QueryGateway queryGateway;

    public CuentaQueryController(QueryGateway queryGateway){
        this.queryGateway = queryGateway;
    }

    @GetMapping
    public List<CuentaRestModel> getAllCuentas(){
        GetCuentasQuery getCuentasQuery = new GetCuentasQuery();

        List<CuentaRestModel> cuentaRestModels =
        queryGateway.query(getCuentasQuery,
                ResponseTypes.multipleInstancesOf(CuentaRestModel.class))
                .join();

        return cuentaRestModels;
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable("id") String id){
        GetSaldoQuery getSaldoQuery = new GetSaldoQuery();
        getSaldoQuery.setId(id);

        String pesos =
                queryGateway.query(getSaldoQuery,
                        ResponseTypes.instanceOf(String.class))
                        .join();

        return pesos;
    }
}
