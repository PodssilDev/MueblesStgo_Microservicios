# MueblesStgo: Aplicación con Microservicios

## Descripción
En este repositorio se encuentra el Backend y Frontend de la aplicación web de MueblesStgo desarrollada utilizando Microservicios. La aplicación esta desarrollada principalmente en Java, utilizando [SpringBoot](https://start.spring.io) y [React JS](https://reactjs.org).

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

## Imágenes de la aplicación
### Menú principal
![image](https://user-images.githubusercontent.com/91446330/203869629-25e0b30e-5a81-4b09-85b3-e911fd4c6e83.png)

### Ver empleados
![image](https://user-images.githubusercontent.com/91446330/203870011-acc44ffe-bd16-4ae2-95ac-fa67df386d36.png)

### Cargar DATA.txt
![image](https://user-images.githubusercontent.com/91446330/203870053-b2473bda-28e7-4e21-8391-2b97b3fa8699.png)

![image](https://user-images.githubusercontent.com/91446330/203870103-6f1140f7-28e5-4e35-adff-9406c14dffee.png)

### Ver el último DATA.txt cargado
![image](https://user-images.githubusercontent.com/91446330/203870120-824ded86-5dd5-4e24-907b-806eed522647.png)

### Ingresar Justificativos
![image](https://user-images.githubusercontent.com/91446330/203870148-1a6e11e3-9fd6-4446-ab04-0802efea8c43.png)

### Ingresar Autorizaciones
![image](https://user-images.githubusercontent.com/91446330/203870165-88aab5d1-8930-405a-9fde-f8773ef98b78.png)

### Planilla de Sueldos
![image](https://user-images.githubusercontent.com/91446330/203870204-30843562-b9f8-4b44-bd59-499b43db0009.png)

### Conección con Keycloak (Seguridad)
![image](https://user-images.githubusercontent.com/91446330/203870230-976511fd-a666-469b-9906-6b08dc5ba2e3.png)

![image](https://user-images.githubusercontent.com/91446330/203870253-b8c43d54-24b6-4a2e-adb5-54917bedcc2f.png)

### Conección con Prometheus y Grafana
![image](https://user-images.githubusercontent.com/91446330/203870353-3dbf4600-c687-4b4f-b5fd-f4863ecf2dc2.png)

### Conección con Spring Eureka
![image](https://user-images.githubusercontent.com/91446330/203870393-9f5095af-ed9b-4353-973c-dd2733891eaa.png)

## Docker-Compose
Se tienen dos docker-compose. El primero es solamente para levantar Config-Service y Eureka-Service.
```sh
docker-compose -f docker-compose-config.yml up
```

El segundo docker-compose levantar el resto de los microservicios, junto con Keycloak y el Frontend de la aplicación.
```sh
docker-compose -f docker-compose-services.yml up
```
