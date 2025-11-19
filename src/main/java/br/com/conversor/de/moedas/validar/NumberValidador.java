package br.com.conversor.de.moedas.validar;

import br.com.conversor.de.moedas.service.exception.NumeroInvalidoException;

public class NumberValidador {
    public void validar(String valor){
        if (numeroNaoPermitido(valor)){
            throw new NumeroInvalidoException("ERRO: O numero " + valor + " não é valido (<=0");
        }
    }

    public boolean numeroNaoPermitido(String valor){
        return Double.parseDouble(valor) <= 0;
    }
}
