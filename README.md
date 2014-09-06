locadora
========

Sistema web para cadastrar veículos de uma locadora de automóveis. O sistema possibilita o cadastro dos campos modelo, 
marca e ano, sendo que o campo ano só pode ser número com 4 digitos, no formato yyyy. O sistema não utiliza banco de dados, 
os dados cadastrados ficam armazenados em memória.

Bibliotecas
-----------

As bibliotecas utilizadas foram: Mojarra 2.1.28, Primefaces 4, jstl 1.2, servlet 2.5 (está com escopo provided no pom.xml
para não ter coflito com o tomcat), el-ri 1.0 (está com escopo provided no pom.xml para não ter coflito com o tomcat).

Requisitos
----------

O projeto foi compilado utilizando eclipse, maven 3 e java 7. Para executar o sistema é necessário ter instalado o java 7.

Execução
--------

Para executar o sistema basta gerar o war e fazer deploy no tomcat 7.

