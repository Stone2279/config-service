package de.stone.config.service.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class ConfigServiceController {

    @GetMapping
    public String hello() {
        return "Hello world";
    }

}
