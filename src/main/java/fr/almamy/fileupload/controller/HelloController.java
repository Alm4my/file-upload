package fr.almamy.fileupload.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HelloController {
    // == Fields ==
    private Map<String, Object> result = new HashMap<>();

    // == Public Methods ==
    @RequestMapping("/hello")
    @ResponseBody
    public Map<String, Object> hello() {
        result.put("name", "Almamy");
        result.put("city", "Abidjan");
        return result;
    }
}
