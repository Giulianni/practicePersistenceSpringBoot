## Persistence Spring Boot - Practice 

- [Consigna](https://github.com/Giulianni/practicePersistenceSpringBoot/files/8446554/Practica.Springboot.-.persistencia.pdf)

`Utilicé relación m-n entre User y Role`

# Tecnologias
- Java
- Spring Boot
- Maven
- Jpa (Hibernate)
- Base64
- MySQL
- [Hosting SQL](https://www.freemysqlhosting.net/)


# Requerimientos - Instalaciones
1. [Java 17](https://www.oracle.com/java/technologies/downloads/#java17)
2. [Maven](https://maven.apache.org/download.cgi)
3. [MySql](https://dev.mysql.com/downloads/workbench/)
4. [Postman](https://www.postman.com/downloads/)

# Instrucciones run app
Projecto runs in Port = 8092

1) Clonar proyecto 
```
git clone https://github.com/Giulianni/practicePersistenceSpringBoot.git
```

2) Abrir pom.xml - "Open from existing sources"
```
persistence
│   
└─── pom.xml 
```

3) Ejecutar en la terminal: 
```
cd persistence
mvn clean install
```

4) Run -> PracticeSpringBootPersistenceApplication
`*La app empezará a correr en el puerto 8092.`
 
 5) Si deseas cambiar el puerto dónde corre la aplicación, deberás cambiar la configuración
 en el archivo 'application.properties'. Si deseas correrlo en el puerto 8080 podés simplemente borrar la propiedad
 y la app correrá en este puerte por default. 
 
 # Instrucciones conectarse a MySQL Workbench al hosting gratuito
 
 1) Click '+' to Setup New Connection con info que provee 'freeMySQLHosting'. Te lo envian por email
 
 ![info sended](https://user-images.githubusercontent.com/81278103/162330891-ef0ae964-06f9-4c37-8811-41bb04d1234a.png)
 
 ![Workbench Form to conection](https://user-images.githubusercontent.com/81278103/162330981-83d44ee3-5765-4cca-a73f-8ba82f6bc480.png)
 
 2) Configurar nombre del Schema en 'application.properties'
 
  - Name = Nombre Schema -> configurarlo en la url
 
   ![url application.properties](https://user-images.githubusercontent.com/81278103/162331998-68edbd4a-2064-4073-85b7-0e261904570d.png)
 
  2.1. Complete la información
 - Hostname = Server
 - Port = Port Number
 - Username = Username
 - Password -> Store in Vault = Password
 
 3) Click 'Test Connection'
 
 4) Al correr la app, en el motor, deberías ver las tablas creadas. En 'application.properties' podés utilizar diferentes configs para la creacion y persistencia de ls datos en la tabla:
 
    https://spring.io/guides/gs/accessing-data-mysql/
 

# Estructuras Proyecto 

```
persistence
│   .mvn/wrapper
|___ src
|   .gitignore
|   PersistencePractice.log
|   mvnw
|   mvnw.cmd
└─── pom.xml
```

![BBDD](https://user-images.githubusercontent.com/81278103/162324091-5540f8a5-9c9c-4ad1-a990-74c66875493f.png)
