package com.tnh.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/keycloak")
public class KeycloakTestController {
    @GetMapping("/")
    public String index() {
        return "external";
    }

    @GetMapping("/customers")
    public String customers() {
        return "customers";
    }
}
