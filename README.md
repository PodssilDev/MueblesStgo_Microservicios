# Técnicas de Ingeniería de Software PEP 2 2022-2: Aplicación con Microservicios

* Autor: John Serrano
* Sección: 13319-0-A-1
* Profesor: Alcides Quispe

## Descripción
En este repositorio se encuentra el Backend y Frontend de la aplicación desarrollada para la PEP 2 de Técnicas de Ingeniería de Software en 2022. La aplicación esta desarrollada principalmente en Java, utilizando [SpringBoot](https://start.spring.io) y [React JS](https://reactjs.org).

## Herramientas utilizadas

Se utilizan las siguientes herramientas principales para desarrollar el proyecto:

* [Java 18](https://www.oracle.com/java/technologies/downloads/): La aplicación utiliza la Programación Orientada a Objetos y se desarrolla utilizando capas, compuestas por Servicios, Entidades, Controladores y Repositorios. Algunos Microservicios también utilizan RestTemplate.
* [IntelliJ IDEA Ultimate 2022.2.2](https://www.jetbrains.com/idea/download/#section=windows): IDE perfecto para trabajar con Java, SpringBoot y todo lo relacionado al Backend del proyecto. Tiene bastante buena compatibilidad con varios plugins y es perfecto para desarollar un proyecto monolítico.
* [React JS](https://reactjs.org): Se utiliza React JS para construir el Frontend de la aplicación. El frontend utiliza algunos React Hooks, como por ejemplo, [Keycloak/Web](https://www.npmjs.com/package/@react-keycloak/web) para poder conectar Keycloak con el Frontend.
* [Visual Studio Code](https://code.visualstudio.com): IDE con multiples compatibilidades que sirve como alternativa a IntelliJ y para editar archivos no provenientes de Java. También es el IDE principalmente utilizado para construir el Frontend de la aplicación.
* [Docker / Docker-Compose / Docker Desktop](https://www.docker.com): Se utiliza Docker junto con Docker-Compose para crear contenedores de Imágenes y asi poder levantar la aplicación en distintos PCs localmente. Las imágenes de Docker se descargan desde [Docker Hub](https://hub.docker.com).
* [Keycloak](https://www.keycloak.org): Se utiliza Keycloak para construir una capa de seguridad para ciertas peticiones del Backend. Keycloak se conecta tanto con Frontend como Backend, por lo que algunas peticiones solo servirán para usuarios autorizados. (La aplicación incluye un login para realizar la autenticación).
* [Prometheus](https://prometheus.io): Se utiliza Prometheus junto con la dependencia Actuator de Spring Boot para poder obtener información sobre el Microservicio OficinaRRHH-Service, el cual calcula y obtiene la planilla de sueldos de los empleados.
* [Grafana](https://grafana.com): Utilizado principalmente para poder visualizar de una manera más agradable la información obtenida por Prometheus.

# Comandos importantes

Los siguientes son comandos importantes a tener en consideración.

### Maven

* Maven Install:
```sh
mvn clean install
```
* Maven Install (Sin tests):
```sh
mvn clean install -DskipTests
```
* Maven Run
```sh
mvn spring-boot:run
```
### Docker
La cuenta de DockerHub utilizada es johnserrano159 y el repositorio depende del microservicio a utilizar. Los repositorios tienen exactamente el mismo nombre que los Microservicios, a excepción del Frontend cuyo repositorio se llama **frontend-mueblsstgo**. Cada Microservicio y el Frontend tienen un Dockerfile.

* Ver contenedores:
```sh
docker ps
```
* Ver Imágenes:
```sh
docker image ls
```
* Docker Build (Crear Imágen)
```sh
docker build -t johnserrano159/<nombre-repositorio>
```
* Eliminar Imágen
```sh
docker rmi <nombre imagen>
```
* Eliminar Contenedor
```sh
docker rm -f <nombre contenedor>
```
* Subir Imágen a DockerHub
```sh
docker push johnserrano159/<nombre-repositorio>
```
* Levantar Contenedores Configuración (Config-Service y Eureka-Service)
```sh
docker-compose -f docker-compose-config.yml up
```
* Levantar Contenedores Servicios (Empleado-Service, Marcas-Reloj-Service, Autorizacion-Service, Justificativo-Service, OficinaRRHH-Service, Gateway-Service, Frontend, Keycloak, junto con sus respectivas Bases de Datos).
```sh
docker-compose -f docker-compose-services.yml up
```
### Keycloak
El usuario para ingresar y su contraseña son admin admin. El usuario con el rol de administrador también tiene el mismo username y password.

### Prometheus
Para levantar Prometheus, dentro de la carpeta de Prometheus:
```sh
prometheus.exe
```

### Grafana
Para levantar Grafana, dentro de la carpeta Bin de Grafana:
```sh
grafana-server.exe
```
