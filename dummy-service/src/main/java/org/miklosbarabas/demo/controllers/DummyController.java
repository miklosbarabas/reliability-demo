package org.miklosbarabas.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DummyController {

    @GetMapping(path = "/dummy")
    public String dummyController() {
        return "dummystuff";
    }
}
