package org.example.currencyconverter;

import org.example.currencyconverter.Controller.ConversionService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CurrencyConverterApplication {

    public static void main(String[] args) {
        SpringApplication.run(CurrencyConverterApplication.class, args);
        ConversionService conversionService = new ConversionService();
        System.out.println(conversionService.getCurrencyDetails());
        System.out.println(conversionService.getConversionRate("ANG","NGN",1000.00));
        System.out.println(conversionService.swapCurrency("USD", "NGN", 1000.0));
    }

}
