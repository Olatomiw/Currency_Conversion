package org.example.currencyconverter.Controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ConversionResponse(String result, String conversion_result, String target_code, String base_code) {
}
