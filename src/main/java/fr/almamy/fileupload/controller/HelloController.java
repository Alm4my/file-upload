package fr.almamy.fileupload.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {
    // == Fields ==
    private final Map<String, Object> result = new HashMap<>();

    // == Public Methods ==
    @RequestMapping("/hello")
    public Map<String, Object> hello() {
        result.put("name", "Almamy");
        result.put("city", "Abidjan");
        return result;
    }
}
