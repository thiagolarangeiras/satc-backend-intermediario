# Projeto Intermediario de Backend
Para mais informações visitar o repositorio 
[Satc Backend](https://github.com/thiagolarangeiras/backend)

# Sobre:
API para criar um Lista de visualização (Watch List) de Filmes e series de TV, Utilizando a API do The Movie Data Base (TMDB) para recuperar dados dos filmes 

# Como Inicializar o programa:    

## Setup de ambiente:

### Java:

Windows
* Baixar o [OpenJdk 21](https://jdk.java.net/21/)
* Instalar ou adicionar a pasta /bin ao PATH do windows
* Rodar `java --version` em algum shell/terminal. O resultado deve ser algo parecido ou identico:  
    > openjdk 21.0.2 2024-01-16     
    > OpenJDK Runtime Environment (build 21.0.2+13-58)      
    > OpenJDK 64-Bit Server VM (build 21.0.2+13-58, mixed mode, sharing)    
* **Opcional:** Instalar o gradle

### API de terceiros:

TMDB (The Movie Data Base)
* Criar uma conta no TMDB [signup](https://www.themoviedb.org/signup)
* Criar uma [chave](https://www.themoviedb.org/settings/api) pode colocar qualquer coisa no cadastro Ex: numero 9999999 ele não valida
  
* Pegar o [API Read Access Token](https://www.themoviedb.org/settings/api)
* Colocar a chave numa variavel de ambiente do seu OS com o nome: ***tmdb_key***    
  Desde que a variavel exista na seção do shell ou global no OS ela vai funcionar
  * Windows: ```set tmdb_key="valor da chave"```
  * Linux: ```tmdb_key="valor da chave"```

## Rodando:

### Terminal
Na pasta raiz do programa rodar o script shell:
```sh
./gradlew bootRun
```
Ou caso você use CMD
```sh
./gradlew.bat bootRun
```
Na teoria o gradlew deveria rodar no windows se você utilizar o Git shell do windows (MSYS2)    

### InteliJ 
Apertar no **Play** **(Shift + F10)** Na Classe "ApiApplication"

### Docker
```sh

```
...


# Funcionamento
Todas as rotas foram definidas na collection do Postman que pode ser encontrada em [postman_collection](./postman_collection.json)

## Controllers e End-Points:

### Ajuda Controller:

#### [GET] /teste
Não faz nada 

#### [GET] /ajuda
Retorna os dados do aluno e do projeto

### Movie Controller:

#### [GET] /searchMovie    
procura filmes na api de terceiros
    
#### [GET] /searchPerson
procura diretores e atores na api de terceiros

#### [GET] /getMovie:     
recupera dados de um filme com base no ID dele na api de terceiros

### Watch List Controller

#### [GET] /watchlist
Recupera todos os dados da lista de filmes

#### [GET] /watchlistfilter
Recupera dados da lista de filmes filtrados

#### [GET] /watchlistmovie
Recupera um filme da lista com base no ID

#### [POST] /watchlist
Insere um filme na lista com base em dados customizados e/ou ID do filme pego do [GET] /searchMovie

#### [PUT] /watchlist 
Altera todos os valores de um filme da lista com base no ID mais dados novos

#### [DELETE] /watchlist
Remove filme da lista com base no ID
