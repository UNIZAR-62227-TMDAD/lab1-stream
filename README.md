# Práctica 1 : Procesos en Streaming

La versión de partida de este repositorio es REST. Se compone de dos aplicaciones:

- *message-dashboard*, servidor web, proporciona una pequeña aplicación web y expone un API de búsqueda.
- *message-factory*, sistema que proporciona acceso a un número infinito de mensajes, tanto de forma bloqueante como asíncrona.

*message-dashboard* delega la respuesta a *message-factory*.

## Detalles técnicos

Para tener un entorno de desarrollo adecuado instala **Java 11** o superior e [IntelliJ IDEA](https://www.jetbrains.com/es-es/idea/download/).
Asegúrate que los plugins **git** y **Kotlin** están instalados. 

A continuación, ves a <https://github.com/UNIZAR-62227-TMDAD/lab1-stream>, bajas el proyecto a tu equipo (preferiblemente con **git**) y lo abres con **IntelliJ IDEA**.

Las tecnologías que usa esta aplicación son:

- Java 11
- Gradle 7.3.3
  - buildSrc
  - Kotlin DSL
- Kotlin 1.6.10
- Spring 2.6.3
- Spring Dependency-Management

## Ejecución

La **Factoría**:

    gradle :message-factory:bootRun

El **Dashboard**:

    gradle :message-dashboard:bootRun

Y ahora vista <http://localhost:8080/>.

## Objetivos

- Estudiar la aplicación, entendiendo cómo está construida.
- Estudiar el comportamiento de la aplicación, ¿qué problemas tienes y cómo se pueden resolver?
