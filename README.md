# DSoftJavaDivas

Proyecto grupal de Diseno del Software ( 4º de ADE + Ingenieria informatica ) 
El proyecto denominado Easybooking, es una plataforma para buscar y reservar vuelos. 

# Pasos para ejecutar

1. mvn clean 
2. mvn compile
3. ant -f build.xml server --> Esto ejecuta el servidor principal
4. ant -f build.xml client --> Esto ejecutara la parte cliente, empezando por el controller y creando las pantallas
5. ant -f build.xml GestorVuelos --> Esto ejecutara el gestor de vuelos
6. ant -f build.xml Buscar
7. ant -f build.xml Entrar_Registrar
 mvn exec:java -Pclient