Projeto de Estudo

ORM com JPA e Hibernate no JSF 2.2 e Persistência de dados (Um CRUD simples)

Para o funcionamento do projeto é necessário criar o banco meuprimeiroprojetojsf no PostgreSQL16

Ir no arquivo persistence.xml e alterar os dados de conexão com seu User e Senha do banco de dados

Para gerar o arquivo WAR no vs code basta ir na opção maven no canto inferior esquerdo clicar com o botão direito no projeto ir em Run Maven commands e install, com isso
o arquivo WAR será gerado dentro da pasta target

No vs code com a extensão Community Server Connectors é possível baixar qualquer versão do apache para realizar o deploy do arquivo WAR e testar o projeto.

Versão do apache para deploy local = 7, em versões superiores não funciona.

Para realizar o deploy vá em servers no canto inferior esquerdo, botão direito sobre o community server e Create new server.
Escolha o apache 7, após baixar o server, botão direito sobre ele e Add Deployment, procure o arquivo WAR e o selecione.

feito isso basta ir com botão direto sobre o apache e Start Server

A url para acessar a página => http://localhost:8080/JSFcomORM-1.0/faces/pagina.xhtml
