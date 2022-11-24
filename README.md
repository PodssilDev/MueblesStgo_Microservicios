# Técnicas de Ingeniería de Software PEP 2 2022-2: Aplicación con Microservicios

* Autor: John Serrano
* Sección: 13319-0-A-1
* Profesor: Alcides Quispe
* Calificación luego de la evaluación: 7.0/7.0

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
