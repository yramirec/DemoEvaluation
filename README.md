# DemoEvaluation

Introducción


Los siguientes pasos le permitirán obtener una copia del proyecto para correrla en la máquina local para propósitos de desarrollo y pruebas.



Prerequisitos


Java

Se necesita instalar Java Development Kit (JDK) 8 para compilar y correr la aplicación.


En Microsoft Windows se debe descargar de la página de descargas en Java SE Downloads.

Maven

Para compilar y empaquetar se utiliza Apache Maven.



Instalación


Para compilar se utilizar Apache Maven:



$ mvn clean package



Esto produce el JAR en target/demo.jar




Despliegue


Para utilizar la aplicación se debe ejecutar



$ java -jar target/demo.jar
