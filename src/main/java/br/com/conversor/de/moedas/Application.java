package br.com.conversor.de.moedas;

import br.com.conversor.de.moedas.controller.ConversorController;
import br.com.conversor.de.moedas.dto.ConversorDTO;
import br.com.conversor.de.moedas.model.Moeda;
import br.com.conversor.de.moedas.repository.ConversorRepository;

public class Application {
    public static void main(String[] args) {
        ConversorController controller = new ConversorController();
        ConversorDTO conversorDTO = controller.converter(Moeda.AUD.getCodigo(), Moeda.AFN.getCodigo());
        System.out.println("Resultado da conversão: ");
        System.out.println(Moeda.fromCodigo(conversorDTO.base_code()).getNome() + " para " + Moeda.fromCodigo(conversorDTO.target_code()).getNome() + " da " + conversorDTO.conversion_rate() + " "+Moeda.fromCodigo(conversorDTO.target_code()).getNome());
        System.out.println("o valor de 100 reais convertido é: " + conversorDTO.converterValor(100));
    }
}
