package com.example.springbootdemoproject;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestDemoMVCController {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testDisplayMessage() {
        String result = restTemplate.getForObject("/message", String.class);
        assertEquals("Hello Ynov", result);
    }
}
