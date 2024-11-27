package org.example.currencyconverter.Response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CurrDetailsResponse(String result, ConversionRates conversion_rates) {
}
