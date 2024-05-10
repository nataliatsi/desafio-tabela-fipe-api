package com.nataliatsi.tabelafipe;

import com.nataliatsi.tabelafipe.menu.Menu;
import com.nataliatsi.tabelafipe.service.VeiculoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TabelaFipeApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(TabelaFipeApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Menu menu = new Menu();
        menu.exibeMenu();

//        VeiculoService v = new VeiculoService();
//
//        System.out.println(" MARCAS ");
//        v.obterMarcas().forEach(System.out::println);
//
//        String modAnos = v.obterModelos().getAnos().toString();
//        String modModelos = v.obterModelos().getModelos().toString();
//
//        System.out.println(" MODELOS ");
//        System.out.println("Anos: " + modAnos);
//        System.out.println("Modelos: " + modModelos);
//
//        System.out.println(" ANOS ");
//        v.obterModelos().getAnos().forEach(System.out::println);
//
//        System.out.println(" MODELOS ");
//        v.obterModelos().getModelos().forEach(System.out::println);
//
//        System.out.println(" DETALHES ");
//        System.out.println("TipoVeiculo: " + v.obterDetalhes().getTipoVeiculo());
//        System.out.println("Valor: R$" + v.obterDetalhes().getValor());
//        System.out.println("Marca: " + v.obterDetalhes().getMarca());
//        System.out.println( "Modelo: " + v.obterDetalhes().getModelo());
//        System.out.println("Ano do Modelo: " + v.obterDetalhes().getModelo());
//        System.out.println("Combustivel: " + v.obterDetalhes().getCombustivel());
//        System.out.println("Mês de Referencia: " + v.obterDetalhes().getMesReferencia());
//        System.out.println("Sigla do Combustível: " + v.obterDetalhes().getSiglaCombustivel());


    }

}
