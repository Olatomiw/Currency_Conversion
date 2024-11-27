package org.example.currencyconverter.Controller;

import org.example.currencyconverter.Response.ConversionResponse;
import org.example.currencyconverter.Response.CurrDetailsResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ConversionService {

    @Value("${currency.api.key}")
    private String key;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final String baseUrl = "https://v6.exchangerate-api.com/v6/731e31d780c5114706c2af79/latest/USD";


    public String getCurrencyDetails(){
        RestTemplate restTemplate = new RestTemplate();
        try {
            CurrDetailsResponse forObject = restTemplate.getForObject(baseUrl, CurrDetailsResponse.class);
            assert forObject != null;
            return forObject.toString();
        }
//        (Map<String, Object>) forObject.get("conversion_rates");
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ConversionResponse getConversionRate(String base_code, String target_code, Double amount){
        RestTemplate restTemplate = new RestTemplate();
        ConversionResponse forObject = restTemplate.getForObject(
                "https://v6.exchangerate-api.com/v6/731e31d780c5114706c2af79/pair/"+base_code+"/"+target_code+"/"+amount,
                ConversionResponse.class);
        assert forObject != null;
        logger.info(forObject.toString());
        return forObject;
    }

    public ConversionResponse swapCurrency(String base_code, String target_code, Double amount){
        String base = target_code;
        String target = base_code;
       return getConversionRate(base, target, amount);
    }



}
