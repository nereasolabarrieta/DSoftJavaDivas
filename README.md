# DSoftJavaDivas

Proyecto grupal de Diseño del Software ( 4º de ADE + Ingeniería informática ) 
El proyecto denominado Easybooking, es una plataforma para buscar y reservar vuelos. 

# Pasos para ejecutar

1. mvn clean 
2. mvn compile
3. mvn datanucleus:schema create
4. mvn exec:java -PventanaPrincipal --> se ejecutará la parte del cliente, mostrando las pantallas de Easybooking.
5. mvn exec:java -PServidor --> se ejecutará la parte correspondiente a la base de datos, para crear, modificar y eliminar objetos.
