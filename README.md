## Persistence Spring Boot - Practice 

- [Consigna](https://github.com/Giulianni/practicePersistenceSpringBoot/files/8446554/Practica.Springboot.-.persistencia.pdf)
*Utilicé relación m-n entre User y Role

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

# Instrucciones
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

3)Ejecutar en la terminal: 
```
cd persistence
mvn clean install
```

4) Run -> PracticeSpringBootPersistenceApplication
*La app empezará a correr en el puerto 8092.
 
 6) Si deseas cambiar el puerto dónde corre la aplicación, deberás cambiar la configuración
 en el archivo 'application.properties'. Si deseas correrlo en el puerto 8080 podés simplemente borrar la propiedad
 y la app correrá en este puerte por default. 

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
