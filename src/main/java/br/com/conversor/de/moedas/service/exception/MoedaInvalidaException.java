package br.com.conversor.de.moedas.service.exception;

public class MoedaInvalidaException extends RuntimeException{
    String mensagem;
    public MoedaInvalidaException(String mensagem){
        super(mensagem);
        this.mensagem = mensagem;
    }
}
