package org.example.currencyconverter.Response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ConversionRates(String USD, String EUR, String GBP,String JPY, String AUD) {
}
