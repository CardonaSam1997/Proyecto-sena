# Evidencia GA7-220501096-AA2-EV01

Codificación de módulos del software según requerimientos del proyecto

### Descripción general

Para esta evidencia se desarrolló el módulo de acceso a datos del sistema, implementando la conexión a bases de datos mediante JDBC, de acuerdo con lo visto en el componente formativo “Construcción de aplicaciones con Java”.

El desarrollo se enfoca en la codificación del módulo, aplicando una arquitectura por capas, específicamente la capa de persistencia (DAO), la cual permite la gestión de datos del sistema.

## Alcance de la evidencia
El alcance de esta evidencia incluye:
- Implementación de conexión a base de datos usando JDBC
- Aplicación del patrón DAO

## Desarrollo de operaciones CRUD:
- Inserción
- Consulta
- Actualización
- Eliminación

## Cumplimiento de estándares de codificación:
- Nombramiento de clases
- Métodos
- Variables y paquetes

Uso de herramientas de versionamiento de software

La capa de presentación (Servlets o interfaz gráfica) no se incluye, ya que no forma parte del alcance definido para esta evidencia, la cual se centra exclusivamente en la lógica de acceso a datos.

# Tecnologías utilizadas
- Java
- JDBC
- Maven
- MySQL
- Patrón DAO
- Git 
- GitHub


# Script de base de datos

-- Crear base de datos
CREATE DATABASE IF NOT EXISTS bussines_task;

USE bussines_task;

-- Crear tabla de usuarios
CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50),
    password VARCHAR(50),
    email VARCHAR(50),
    role VARCHAR(15),
    authentication TINYINT(1),
    enable TINYINT(1),
    completed TINYINT(1),
    created_at DATETIME,
    updated_at DATETIME
);

Este módulo sirve como base para la posterior integración de capas superiores del sistema, como controladores (Servlets) y capa de presentación, las cuales podrán consumir los métodos definidos en la capa DAO.