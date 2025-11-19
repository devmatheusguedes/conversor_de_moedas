package br.com.conversor.de.moedas.service;

import br.com.conversor.de.moedas.dto.ConversorDTO;
import br.com.conversor.de.moedas.repository.ConversorRepository;
import br.com.conversor.de.moedas.validar.ValidadorDeMoeda;

public class ConversorService {
    private final ConversorRepository repository;
    private final ValidadorDeMoeda validador;

    public ConversorService(){
        repository = new ConversorRepository();
        validador = new ValidadorDeMoeda();
    }

    public ConversorDTO converter(String base, String conversao){
        String[] codigoMoedas = new String[]{base, conversao};
        validador.validar(codigoMoedas);
        return repository.converter(base, conversao);
    }


}
