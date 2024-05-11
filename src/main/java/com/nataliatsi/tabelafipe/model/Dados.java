package com.nataliatsi.tabelafipe.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Dados(String codigo, String nome) {
    @Override
    public String toString() {
        return String.format("Código: %s, Nome: %s",
                codigo, nome);
    }
}
