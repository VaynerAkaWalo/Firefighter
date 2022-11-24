package com.blamedevs.firefighter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirefighterController {

    @GetMapping("/firefighter")
    public String index() {
        return "index.html";
    }
}
