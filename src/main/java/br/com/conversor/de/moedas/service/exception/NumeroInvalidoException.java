package br.com.conversor.de.moedas.service.exception;

public class NumeroInvalidoException extends RuntimeException{
    String mensagem;
    public NumeroInvalidoException(String mensagem){
        super(mensagem);
        this.mensagem = mensagem;
    }
}
