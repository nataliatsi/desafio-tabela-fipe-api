package com.nataliatsi.tabelafipe.menu;

import com.nataliatsi.tabelafipe.model.Dados;
import com.nataliatsi.tabelafipe.model.Modelos;
import com.nataliatsi.tabelafipe.model.Veiculo;
import com.nataliatsi.tabelafipe.service.ConsumoApi;
import com.nataliatsi.tabelafipe.service.ConverteDados;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Menu {
    private final Scanner scanner = new Scanner(System.in);
    private ConsumoApi consumoApi = new ConsumoApi();
    private final ConverteDados converteDados = new ConverteDados();
    private String END_BASE = "https://parallelum.com.br/fipe/api/v1/";

    public void exibeMenu() {
        System.out.println("Escolha o tipo do veículo:");
        String menu = """
                ------ OPÇÕES ------
                1. Carros
                2. Motos
                3. Caminhões
                --------------------
                """;
        System.out.println(menu);

        int tipoVeiculo = scanner.nextInt();
        scanner.nextLine();

        String endereco = null;

        if (tipoVeiculo == 1) {
            endereco = END_BASE + "carros/marcas";
        } else if (tipoVeiculo == 2) {
            endereco = END_BASE + "motos/marcas";
        } else if (tipoVeiculo == 3) {
            endereco = END_BASE + "caminhoes/marcas";
        } else {
            System.out.println("Opção inválida.");
        }

        obterListaDeMarcas(endereco);
        List<Dados> modelosLista = consultarModelosPorMarca(endereco);

        if (modelosLista == null || modelosLista.isEmpty()) {
            System.out.println("Nenhum modelo encontrado para a marca informada.");
            return;
        }

        List<Dados> veiculosEncontrados = consultarVeiculosPorModelo(modelosLista);
        if (veiculosEncontrados.isEmpty()) {
            System.out.println("Nenhum veículo encontrado para o modelo informado.");
        }

        // TODO: atualizar variavel endereco
        //consultarVeiculosPorModeloAno(endereco);

    }

    private void obterListaDeMarcas(String endereco) {
        String json = consumoApi.obterDados(endereco);
        List<Dados> marcas = converteDados.obterLista(json, Dados.class);

        marcas.stream()
                .sorted(Comparator.comparing(Dados::codigo))
                .forEach(System.out::println);
    }

    private List<Dados> consultarModelosPorMarca(String endereco) {
        System.out.println("Informe o código da marca para consultar os modelos: ");
        String codMarca = scanner.nextLine();

        endereco = endereco + "/" + codMarca + "/modelos";
        var json = consumoApi.obterDados(endereco);

        Modelos modelosLista = converteDados.obterDados(json, Modelos.class);

        if (modelosLista == null || modelosLista.modelos() == null || modelosLista.modelos().isEmpty()) {
            System.out.println("Nenhum modelo encontrado para a marca informada.");
        }

        assert modelosLista != null;
        assert modelosLista.modelos() != null;

        modelosLista.modelos().stream()
                .sorted(Comparator.comparing(Dados::codigo))
                .forEach(System.out::println);

        return modelosLista.modelos();
    }

    private List<Dados> consultarVeiculosPorModelo(List<Dados> modelosLista) {
        System.out.println("Informe o nome do modelo para consultar os veículos: ");
        var nomeVeiculo = scanner.nextLine();

        List<Dados> dadosList = modelosLista.stream()
                .filter(m -> m.nome().toLowerCase().contains(nomeVeiculo.toLowerCase()))
                .collect(Collectors.toList());

        dadosList.forEach(System.out::println);

        return dadosList;
    }


    private void consultarVeiculosPorModeloAno(String endereco) {
        System.out.println("Digite o código do modelo: ");
        String codModelo = scanner.nextLine();
        endereco = endereco + "/" + codModelo + "/anos";
        var json = consumoApi.obterDados(endereco);

        List<Dados> anos = converteDados.obterLista(json, Dados.class);
        List<Veiculo> veiculos = new ArrayList<>();

        for(int i = 0; i < anos.size(); i++) {
            var enderecoAnos = endereco + "/" + anos.get(i).codigo();
            json = consumoApi.obterDados(enderecoAnos);
            Veiculo veiculo = converteDados.obterDados(json, Veiculo.class);
            veiculos.add(veiculo);
        }

        System.out.println("Veículos: ");
        veiculos.forEach(System.out::println);

    }

}

