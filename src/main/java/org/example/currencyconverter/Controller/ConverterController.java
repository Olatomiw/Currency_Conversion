package org.example.currencyconverter.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConverterController {

    @GetMapping("/")
    public String home() {
        return "Hello World";
    }
}
