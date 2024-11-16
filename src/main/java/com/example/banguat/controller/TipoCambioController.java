package com.example.banguat.controller;

import com.example.banguat.service.TipoCambioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tipo-cambio")
@RequiredArgsConstructor
public class TipoCambioController {

    private final TipoCambioService service;

    @GetMapping
    public String getTipoCambio() {
        return service.consultarTipoCambio();
    }
}