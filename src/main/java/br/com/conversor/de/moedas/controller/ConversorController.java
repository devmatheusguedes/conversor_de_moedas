package br.com.conversor.de.moedas.controller;

import br.com.conversor.de.moedas.dto.ConversorDTO;
import br.com.conversor.de.moedas.service.ConversorService;

public class ConversorController {
    private final ConversorService service;

    public ConversorController() {
        this.service = new ConversorService();
    }

    public ConversorDTO converter(String base, String converter){
        return service.converter(base, converter);
    }
}
