### To get data from other service in older way:

```java

@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
public CurrencyConversion calculateCurrencyConversion(
        @PathVariable String from,
        @PathVariable String to,
        @PathVariable BigDecimal quantity
) {

    HashMap<String, String> uriVariables = new HashMap<>();
    uriVariables.put("from", from);
    uriVariables.put("to", to);

    ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate()
            .getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}",
                    CurrencyConversion.class, uriVariables);
    CurrencyConversion currencyConversion = responseEntity.getBody();
    return new CurrencyConversion(currencyConversion.getId(),
            from, to, quantity,
            currencyConversion.getConversionMultiple(),
            quantity.multiply(currencyConversion.getConversionMultiple()),
            currencyConversion.getEnvironment());
}
```

### To get data in new way using feign:

1. Add this dependency:
```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-openfeign</artifactId>
</dependency>
```
2. Create a proxy:
```java
@FeignClient(name = "currency-exchange", url = "localhost:8000")
public interface CurrencyExchangeProxy {
    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyConversion retrieveExchange(
            @PathVariable String from,
            @PathVariable String to
    );
}
```
3. Autowire it to controller and use to retrieve information from other microservice:
```java
@Autowired
CurrencyExchangeProxy proxy;

@GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
public CurrencyConversion calculateCurrencyConversionFeign(
        @PathVariable String from,
        @PathVariable String to,
        @PathVariable BigDecimal quantity
) {
    CurrencyConversion currencyConversion = proxy.retrieveExchange(from, to);
    return new CurrencyConversion(currencyConversion.getId(),
            from, to, quantity,
            currencyConversion.getConversionMultiple(),
            quantity.multiply(currencyConversion.getConversionMultiple()),
            currencyConversion.getEnvironment());
}
```