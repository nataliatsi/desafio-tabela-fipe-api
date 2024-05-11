package com.nataliatsi.tabelafipe.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Veiculo(
        @JsonAlias("Valor") String valor,
        @JsonAlias("Marca") String marca,
        @JsonAlias("Modelo") String modelo,
        @JsonAlias("AnoModelo") int anoModelo,
        @JsonAlias("Combustivel") String combustivel,
        @JsonAlias("CodigoFipe") String codigoFipe
) {
    @Override
    public String toString() {
        return String.format("Modelo: %s, Valor: %s, Marca: %s, Ano do Modelo: %d, Combustivel: %s, Código Fipe: %s",
                modelo, valor, marca, anoModelo, combustivel, codigoFipe);
    }
}
