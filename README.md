# taskManager
Projeto de Gerenciador de Tarefas (JSF-JPA-Postgres)

Sobre o projeto:

Para este projeto de gerenciador de tarefas foram implementados os itens:
    a) Criar uma aplicação Java Web utilizando JavaServer Faces (JSF)
      - JSF 2.2
    b) Utilizar persistência em um banco de dados PostgreSQL
      - O banco foi implementado na versão 14 do PostgreSQL
    c) Utilizar JPA
      - Foi utilizado o JPA 2.1, através do hibernate 4.3
    
    Para o fornecimento de componentes visuais do projeto, também foram utilizados os frameworks bootstrap e primefaces.
    
As seguintes funcionalidades foram implementadas:
    - Criar uma tarefa
    - Atualizar a tarefa
    - Remover a tarefa
    - Concluir Tarefa
    - Listar tarefas
    
   
O projeto está configurado para rodar no servidor Glassfish 4.1 e pode ser clonado diretamente pelo Netbeans ou Eclipse.
As configurações do banco podem ser alteradas no "persistence.xml", com os acessos locais da máquina que irá rodar.
O conector jdbc do postgres que está no projeto é o mais recente, para versões anteriores do banco deve-se buscar o 
conector corresponte e substituir nas libs.
    
    



