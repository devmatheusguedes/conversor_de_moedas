package br.com.conversor.de.moedas.repository;

import br.com.conversor.de.moedas.dto.ConversorDTO;
import br.com.conversor.de.moedas.model.Moeda;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversorRepository {
    public ConversorDTO converter(String base, String conversao) {
        HttpClient cliente = HttpClient.newHttpClient();
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .setPrettyPrinting()
                .create();
        URI endereco = URI.create("https://v6.exchangerate-api.com/v6/0870739541e0be54f86254de/pair/" + base + "/"
                + conversao);
        HttpRequest requisicao = HttpRequest.newBuilder()
                .uri(endereco)
                .GET()
                .build();

        try {
            // Enviando requisição e recebendo resposta
            HttpResponse<String> resposta = cliente.send(requisicao, HttpResponse.BodyHandlers.ofString());
            return gson.fromJson(resposta.body(), ConversorDTO.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
