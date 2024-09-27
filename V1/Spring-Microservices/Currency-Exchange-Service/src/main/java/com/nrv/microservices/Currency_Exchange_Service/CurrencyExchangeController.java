package com.nrv.microservices.Currency_Exchange_Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

    @Autowired
    CurrencyExchangeRepo exchangeRepo;

    @Autowired
    private Environment environment;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchange(
            @PathVariable String from,
            @PathVariable String to
    ) {
        CurrencyExchange currencyExchange = exchangeRepo.findByFromAndTo(from, to);
        if (currencyExchange == null) {
            throw new RuntimeException("Data not available");
        }
        String port = environment.getProperty("local.server.port");
        currencyExchange.setEnvironment(port);
        return currencyExchange;
    }

}
