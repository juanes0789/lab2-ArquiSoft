package com.udea.lab22026;

import com.github.javafaker.Faker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;
import java.util.Locale;


@RestController

public class DataController {
    @GetMapping("/")
    public String healthCheck() {
        return "Hola, esta es una respuesta desde el controlador de datos.";
    }

    @GetMapping("/version")
    public String version() {
        return "The actual version is 1.0.0 ";
    }

    @GetMapping("/nations")
    public JsonNode GetRandomNations() {
        var objectMapper = new ObjectMapper();
        var faker = new Faker(new Locale("en-US"));
        var nations = objectMapper.createArrayNode();
        for (int i = 0; i < 10; i++) {
            var nation = faker.nation();
            nations.add(objectMapper.createObjectNode()
                    .put("Nationality", nation.nationality())
                    .put("Capital", nation.capitalCity())
                    .put("Language", nation.language())
                    .put("Flag", nation.flag())
            );

        }
        return nations;

    }

    @GetMapping("/currencies")
    public JsonNode GetRandomCurrencies() {
        var objectMapper = new ObjectMapper();
        var faker = new Faker(new Locale("en-US"));
        var currencies = objectMapper.createArrayNode();
        for (int i = 0; i < 10; i++) {
            var currency = faker.currency();
            currencies.add(objectMapper.createObjectNode()
                    .put("Code", currency.code())
                    .put("Name", currency.name())

            );

        }
        return currencies;

    }
    @GetMapping("/aviation")
    public JsonNode GetRandomAviation() {
        var objectMapper = new ObjectMapper();
        var faker = new Faker(new Locale("en-US"));
        var aviations = objectMapper.createArrayNode();
        for (int i = 0; i < 10; i++) {
            var aviation = faker.aviation();
            aviations.add(objectMapper.createObjectNode()
                    .put("aircraft", aviation.aircraft())
                    .put("Airport", aviation.airport())
                    .put("Metar", aviation.METAR())
            );

        }
        return aviations;

    }



}
