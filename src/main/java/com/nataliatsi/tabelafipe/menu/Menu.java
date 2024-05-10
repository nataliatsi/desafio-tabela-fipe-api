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

//
public class Menu {
    private Scanner scanner = new Scanner(System.in);
    private final String END_BASE = "https://parallelum.com.br/fipe/api/v1/";
    private ConsumoApi consumoApi = new ConsumoApi();
    private ConverteDados converteDados =  new ConverteDados();

    public void exibeMenu(){
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

        if(tipoVeiculo == 1){
            endereco = END_BASE + "carros/marcas";
        } else if (tipoVeiculo == 2) {
            endereco = END_BASE + "motos/marcas";
        } else if (tipoVeiculo == 3) {
            endereco = END_BASE + "caminhoes/marcas";
        } else {
            System.out.println("Opção inválida.");
        }

        var json = consumoApi.obterDados(endereco);
        System.out.println(json);

        var marcas = converteDados.obterLista(json, Dados.class);
        marcas.stream()
                .sorted(Comparator.comparing(Dados::codigo))
                .forEach(System.out::println);

        System.out.println("Informe o código da marca para consultar os modelos: ");
        var codMarca = scanner.nextLine();

        endereco = endereco + "/" + codMarca + "/modelos";
        json = consumoApi.obterDados(endereco);

        var modelosLista = converteDados.obterDados(json, Modelos.class);
        modelosLista.modelos().stream()
                .sorted(Comparator.comparing(Dados::codigo))
                .forEach(System.out::println);

        System.out.println("Informe o nome do modelo para consultar os veículos: ");
        var nomeVeiculo = scanner.nextLine();

        List<Dados> dadosList = modelosLista.modelos().stream().filter(m -> m.nome().toLowerCase().contains(nomeVeiculo.toLowerCase()))
                .collect(Collectors.toList());

        dadosList.forEach(System.out::println);

        System.out.println("Digite o código do modelo: ");
        var codModelo = scanner.nextLine();

        endereco = endereco + "/" + codModelo + "/anos";
        json = consumoApi.obterDados(endereco);

        List<Dados> anos = converteDados.obterLista(json, Dados.class);
        List<Veiculo> veiculos = new ArrayList<>();

        for (int i = 0; i < anos.size(); i++) {
            var enderecoAnos = endereco + "/" + anos.get(i).codigo();
            json = consumoApi.obterDados(enderecoAnos);
            Veiculo veiculo = converteDados.obterDados(json, Veiculo.class);
            veiculos.add(veiculo);

        }

        System.out.println("Veículos: ");
        veiculos.forEach(System.out::println);

    }
//    private final VeiculoService veiculoService = new VeiculoService();
////
////    public void exibirMenu() {
////        while (true) {
////            System.out.println("Selecione uma opção:");
////            System.out.println("1. Consultar Marcas");
////            System.out.println("2. Consultar Modelos");
////            System.out.println("3. Consultar Anos");
////            System.out.println("4. Consultar Detalhes");
////            System.out.println("5. Sair");
////
////            int opcao = scanner.nextInt();
////
////            switch (opcao) {
////                case 1:
////                    consultarMarcas();
////                    break;
////                case 2:
////                    //consultarModelos();
////                    break;
////                case 3:
////                    consultarAnos();
////                    break;
////                case 4:
////                    consultarDetalhes();
////                    break;
////                case 5:
////                    System.out.println("Saindo...");
////                    return;
////                default:
////                    System.out.println("Opção inválida!");
////            }
////        }
////    }
//
//    private void consultarMarcas() {
//        Marca m = veiculoService.obterMarcas("carros");
//        List<Marca> marcas = new ArrayList<>();
//        marcas.add(m);
//        marcas.forEach(marca -> System.out.println(marca.codigo() + " - " + marca.nome()));
//    }
//
//
////    private void consultarModelos() {
////        System.out.println("Digite o código da marca:");
////        String codigoMarca = scanner.nextLine();
////        Modelo m = veiculoService.obterModelos("carros", codigoMarca);
////        List<Modelo> modelos = new ArrayList<>();
////        modelos.add(m);
////        modelos.forEach(modelo -> System.out.println(modelo.codigo() + " - " + modelo.nome()));
////    }
//
//    private void consultarAnos() {
//        System.out.println("Digite o código da marca:");
//        String codigoMarca = scanner.nextLine();
//        System.out.println("Digite o código do modelo:");
//        String codigoModelo = scanner.nextLine();
//        Ano n = veiculoService.obterAnos("carros", codigoMarca, codigoModelo);
//        List<Ano> anos = new ArrayList<>();
//        anos.add(n);
//        anos.forEach(ano -> System.out.println(ano.codigo() + " - " + ano.nome()));
//    }
//
//    private void consultarDetalhes() {
//        System.out.println("Digite o código da marca:");
//        String codigoMarca = scanner.nextLine();
//        System.out.println("Digite o código do modelo:");
//        String codigoModelo = scanner.nextLine();
//        System.out.println("Digite o código do ano:");
//        String codigoAno = scanner.nextLine();
//        Detalhes detalhes = veiculoService.obterDetalhes("carros", codigoMarca, codigoModelo, codigoAno);
//        System.out.println("Marca: " + detalhes.marca());
//        System.out.println("Modelo: " + detalhes.modelo());
//        System.out.println("Ano Modelo: " + detalhes.anoModelo());
//        System.out.println("Valor: " + detalhes.valor());
//        System.out.println("Combustível: " + detalhes.combustivel());
//        System.out.println("Código FIPE: " + detalhes.codigoFipe());
//        System.out.println("Mês Referência: " + detalhes.mesReferencia());
//        System.out.println("Sigla Combustível: " + detalhes.siglaCombustivel());
//    }
}
