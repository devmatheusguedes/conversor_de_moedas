package br.com.conversor.de.moedas.dto;

import br.com.conversor.de.moedas.validar.NumberValidador;

public record ConversorDTO(String base_code, String target_code, String conversion_rate) {
    public Double converterValor(double valor){
        return valor * Double.parseDouble(conversion_rate);
    }
    public String converterValor(String valor){
        NumberValidador numberValidador = new NumberValidador();
        numberValidador.numeroNaoPermitido(valor);

        double v = Double.parseDouble(valor) * Double.parseDouble(conversion_rate);
        return String.valueOf(v);
    }

}
