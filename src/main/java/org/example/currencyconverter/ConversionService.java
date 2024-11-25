package org.example.currencyconverter;

import org.example.currencyconverter.Controller.ConversionResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Component
public class ConversionService {

    @Value("${currency.api.key}")
    private String key;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final String baseUrl = "https://v6.exchangerate-api.com/v6/731e31d780c5114706c2af79/latest/USD";
    private final String conversionUrl = "https://v6.exchangerate-api.com/v6/731e31d780c5114706c2af79/pair/USD/NGN/";


    public Map<String, Object> getCurrencyDetails(){
        RestTemplate restTemplate = new RestTemplate();
        try {
            HashMap<String, Object> forObject = restTemplate.getForObject(baseUrl, HashMap.class);
            assert forObject != null;
            return (Map<String, Object>) forObject.get("conversion_rates");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ConversionResponse getConversionRate(String base_code, String target_code, Double amount){
        RestTemplate restTemplate = new RestTemplate();
        ConversionResponse forObject = restTemplate.getForObject("https://v6.exchangerate-api.com/v6/731e31d780c5114706c2af79/pair/"+base_code+"/"+target_code+"/"+amount, ConversionResponse.class);
        logger.info(forObject.toString());
        return forObject;
    }

}
