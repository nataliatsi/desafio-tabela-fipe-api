# Desafio Tabela FIPE API

Este é um projeto desenvolvido como parte do curso Java: trabalhando com lambdas, streams e Spring Framework, no contexto do desafio proposto. O objetivo é exercitar os conhecimentos adquiridos ao longo do curso, aplicando conceitos como listas, coleções, funções lambdas, streams e consumo de API.

## Funcionalidades

- O programa inicia exibindo um menu com opções para selecionar o tipo de veículo: carros, motos ou caminhões. Consulta de Marcas:

```plaintext
Escolha o tipo do veículo:
------ OPÇÕES ------
1. Carros
2. Motos
3. Caminhões
--------------------
1
```

- Após selecionar o tipo de veículo, o programa consulta a API da Tabela FIPE para obter uma lista de marcas disponíveis. Consulta de Modelos por Marca:

```plaintext
Código: 1, Nome: Acura
Código: 10, Nome: Cadillac
Código: 11, Nome: CBT Jipe 
{...}
```

- O usuário informa o código da marca desejada e o programa consulta a API para obter os modelos correspondentes.
Consulta de Veículos por Modelo:

```plaintext
Informe o código da marca para consultar os modelos: 
21
Código: 10065, Nome: Stilo Dualogic 1.8 ATTRACTIVE Flex 8V 5p
Código: 10069, Nome: Toro Freedom 2.0 16V 4x4 TB Diesel Aut.
Código: 10070, Nome: Toro Ranch 2.0 16V 4x4 TB Diesel Aut.
{...}
```

- O usuário informa o nome do modelo desejado e o programa lista os veículos correspondentes, filtrando pela entrada do usuário.
Consulta de Veículos por Modelo e Ano:

```plaintext
Informe o nome do modelo para consultar o(s) veículo(s): 
palio
Código: 4826, Nome: Palio 1.0 Cel. ECON./ITALIA F.Flex 8V 4p
Código: 4825, Nome: Palio 1.0 Celebr. ECONOMY F.Flex 8V 2p
Código: 4827, Nome: Palio 1.0 ECONOMY Fire Flex 8V 2p
{...}
```

- Após selecionar um modelo, o usuário informa o código do modelo desejado. O programa então consulta a API para obter os anos disponíveis para o modelo selecionado e lista os veículos correspondentes.

```plaintext
Digite o código do modelo: 
545

Lista de Veículo(s) que correspondem com a sua busca: 
Modelo: Palio Weekend Adventure 1.6 8V/16V, Valor: R$ 16.167,00, Marca: Fiat, Ano do Modelo: 2003, Combustivel: Gasolina, Código Fipe: 001111-8
Modelo: Palio Weekend Adventure 1.6 8V/16V, Valor: R$ 14.606,00, Marca: Fiat, Ano do Modelo: 2002, Combustivel: Gasolina, Código Fipe: 001111-8
Modelo: Palio Weekend Adventure 1.6 8V/16V, Valor: R$ 14.145,00, Marca: Fiat, Ano do Modelo: 2001, Combustivel: Gasolina, Código Fipe: 001111-8
Modelo: Palio Weekend Adventure 1.6 8V/16V, Valor: R$ 11.861,00, Marca: Fiat, Ano do Modelo: 2000, Combustivel: Gasolina, Código Fipe: 001111-8
Modelo: Palio Weekend Adventure 1.6 8V/16V, Valor: R$ 10.214,00, Marca: Fiat, Ano do Modelo: 1999, Combustivel: Gasolina, Código Fipe: 001111-8
```

## Utilização
Para utilizar a api, basta seguir estes passos:
1. Clone o repositório para o seu ambiente local.
2. Certifique-se de ter o Java instalado em seu sistema.
3. Compile e execute o projeto.
4. Siga as instruções apresentadas no console para realizar as conversões desejadas.

## API Utilizada
A api utiliza a FIPE API HTTP REST para obter preços médios de veículos no mercado nacional. Atualizada mensalmente com dados extraidos da tabela FIPE. Para mais informações, visite [FIPE API HTTP REST](https://deividfortuna.github.io/fipe/).

## Requisitos
- Java 8 ou superior.
- Conexão com a internet para acessar a FIPE API HTTP REST.

## Contribuição
Contribuições são bem-vindas! Sinta-se à vontade para enviar pull requests com melhorias, correções de bugs ou novas funcionalidades ✨
