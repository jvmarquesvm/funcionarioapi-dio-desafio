# funcioanrioapi-dio-desafio

<h2>Digital Innovation: Expert class - Desenvolvendo um sistema de gerenciamento de pessoas em API REST com Spring Boot</h2>

Neste projeto foi construído do zero uma API REST com Spring Boot para cadastro e gerenciamento de pessoas de uma organização, até o Deploy na nuvem (Heroku). Neste caso trata-se de funcionários e seus treinamentos realizados.

Durante o desenvolvimento foram abordados os seguintes tópicos:

* Setup inicial de projeto com o Spring Boot Initialzr. 
* Criação de modelo de dados para o mapeamento de entidades em bancos de dados.
** Entidade de Funcionario e Treinamento.
* Desenvolvimento de operações de gerenciamento de usuários(Funcionario) (Cadastro, leitura, atualização e remoção de pessoas de um sistema) e seus treinamentos realizados.
* Relação de cada uma das operações acima com o padrão arquitetural REST.
* Desenvolvimento de testes unitários para validação das funcionalidades.
* Implantação do sistema na nuvem através do Heroku.
* Verificar o modelo do banco de dados através - arquivo: modelobancodedados.png.
* Collection Insominia para a chamada dos serviços - arquivo: Insomnia_2022-01-29.null.

Para executar o projeto no terminal, digite o seguinte comando:

```shell script
mvn spring-boot:run 
```

Após executar o comando acima, basta apenas abrir o seguinte endereço e visualizar a execução do projeto:

```
Operações:

Criar funcionario - POST - http://localhost:8080/v1/api/funcionario
Criar treinamento para funcionario - POST - http://localhost:8080/v1/api/treinamento
Buscar todos os treinamentos por funcionario - GET - http://localhost:8080/v1/api/funcionario/{idFuncionario}/treinamento
Buscar funcionario por id - GET - http://localhost:8080/v1/api/funcionario/{idFuncionario}
Atualizar funcionario - PUT - http://localhost:8080/v1/api/funcionario/{idFuncionario}
Apagar funcionario - DELETE - http://localhost:8080/v1/api/funcionario/{idFuncionario}
Buscar todos os funcionarios - GET - http://localhost:8080/v1/api/funcionario
Buscar todos os treinamentos cadastrados - GET - http://localhost:8080/v1/api/treinamento
Apagar treinamento - DELETE - http://localhost:8080/v1/api/treinamento/{idFuncionario}
```



São necessários os seguintes pré-requisitos para a execução do projeto desenvolvido durante a aula:

* Java 11 ou versões superiores.
* Maven 3.6.3 ou versões superiores.
* Spring Tool Suite 4 / Eclipse IDE.
* Controle de versão GIT instalado.
* Conta no GitHub para o armazenamento do seu projeto na nuvem.
* Conta no Heroku para o deploy do projeto na nuvem.
