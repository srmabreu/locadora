locadora
========

Sistema web para cadastrar veículos de uma locadora de automóveis. O sistema possibilita o cadastro dos campos: modelo, 
marca e ano, sendo que todos os campos são obrigatórios e o campo ano só pode ser número com 4 digitos no formato yyyy. 
O sistema não utiliza banco de dados, os dados cadastrados ficam armazenados em memória. O projeto foi feito com jsf 2.1,
primefaces 4, facelets e bootstrap 3.1.1.

Requisitos
----------

O projeto foi compilado utilizando eclipse Kepler com encoding UTF-8, maven 3 e java 7. Para executar o sistema é necessário 
ter instalado o java 7.

Bibliotecas
-----------

As bibliotecas utilizadas estão declaradas no arquivo pom.xml. As bibliotecas são: Mojarra 2.1.28, Primefaces 4, jstl 1.2, 
servlet 2.5 (está com escopo provided no pom.xml para não ter coflito com o tomcat), el-ri 1.0 (está com escopo provided 
no pom.xml para não ter coflito com o tomcat).

Execução
--------

Para executar o sistema basta gerar o war, fazer deploy no tomcat 7 e acessar a url localhost:8080/locadora. Ao acessar
esse endereço o sistema exibe a tela com a lista de veículos cadastrados. 

