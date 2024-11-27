package org.example.currencyconverter.Response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ConversionResponse(String result, String conversion_result, String base_code, String target_code) {
}
