# Apidefilmes

Este é um projeto Java que consome a API OMDB para buscar informações sobre filmes e salvar os resultados em um arquivo JSON.

## Pré-requisitos

- Java 8 ou superior


## Configuração

1. Clone o repositório para o seu ambiente local:

   ```bash
   git clone https://github.com/igorpereirag/apidefilmes.git
   ```

2. Abra o projeto em sua IDE favorita.

3. No arquivo `PrincipalCogatomBusca.java`, substitua `"sua-chave-de-api"` pela sua chave de API da OMDB.

## Execução

1. Dê um run na classe "PrincipalComBusca.java"

2. Siga as instruções no console para buscar filmes. Digite o nome do filme desejado ou "sair" para encerrar a busca.

3. Após concluir a busca, os resultados serão salvos em um arquivo `titulos.json` na raiz do projeto.

## Estrutura do Projeto

- `Apiconnect.java`: Classe responsável por se conectar à API OMDB e buscar informações sobre os filmes.
- `PrincipalComBusca.java`: Classe principal que gerencia a busca e salva os resultados em um arquivo JSON.
- `Titulo.java`: Classe de modelo para representar os títulos dos filmes.
- `TituloOmdb.java`: Classe de modelo para representar os dados retornados pela API OMDB.

