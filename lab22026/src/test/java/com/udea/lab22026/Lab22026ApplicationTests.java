package com.udea.lab22026;



import tools.jackson.databind.JsonNode;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class Lab2pApplicationTests {

    @Autowired
    DataController dataController;

    @Test
    void health(){
        assertEquals("Hola, esta es una respuesta desde el controlador de datos.", dataController.healthCheck());
    }

    @Test
    void version(){
        assertEquals("The actual version is 1.0.0 ", dataController.version());
    }

    @Test
    void nationLength(){
        Integer nationsLength = dataController.GetRandomNations().size();
        assertEquals(10, nationsLength);
    }

    @Test
    void currenciesLength(){
        Integer currenciesLength = dataController.GetRandomCurrencies().size();
        assertEquals(10, currenciesLength);
    }

    @Test
    public void testRandomCurrenciesCodeFormat(){
        DataController controller = new DataController();
        JsonNode response = controller.GetRandomCurrencies();
        for(int i=0; i< response.size(); i++){
            JsonNode currency = response.get(i);
            String code = currency.get("Code").asText();
            assertTrue(code.matches("[A-Z]{3}"));
        }
    }

    @Test
    public void testRandomNationsPerformance() {
        DataController controller = new DataController();
        long startTime = System.currentTimeMillis();

        controller.GetRandomNations();
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        System.out.println(executionTime);
        assertTrue(executionTime < 2000);
    }

    @Test
    void aviationsLength(){
        Integer aviationsLength = dataController.GetRandomAviation().size();
        assertEquals(10, aviationsLength);
    }
}






