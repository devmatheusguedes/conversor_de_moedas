package br.com.conversor.de.moedas.validar;

import br.com.conversor.de.moedas.model.Moeda;
import br.com.conversor.de.moedas.service.exception.MoedaInvalidaException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValidadorDeMoeda {
    public void validar(String... codigosMoeda){
        List<String> codigosInvalidos = Arrays.stream(codigosMoeda)
                .filter(c -> !Moeda.existeCodigo(c))
                .toList();

        if (!codigosInvalidos.isEmpty()) {
            throw new MoedaInvalidaException(
                    "Erro: Código(s) de moeda inválido(s): " + codigosInvalidos
            );
        }

    }

    private boolean todasMoedasExistem(String... codigos) {
        return Arrays.stream(codigos)
                .allMatch(Moeda::existeCodigo);
    }

}
