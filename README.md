# Roles

Aplicación Android desarrollada como prueba técnica utilizando Jetpack Compose, MVVM y Clean Architecture.

## Características

- Inicio de sesión mediante servicio REST.
- Autenticación utilizando JWT.
- Persistencia de sesión.
- Registro de personas.
- Almacenamiento local con Room.
- Consulta de registros locales.
- Consulta de registros remotos.
- Eliminación de registros únicamente para usuarios con rol Supervisor.
- Validación de formularios.
- Navegación con Navigation Compose.

---

## Arquitectura

El proyecto está desarrollado siguiendo el patrón 
**MVVM (Model - View - ViewModel)** y 
**Clean Architecture**, dividido en las siguientes capas:

```
presentation
│
├── ui
├── viewmodel
└── components

domain
│
├── model
├── repository
└── usecase

data
│
├── local
├── remote
├── repository
└── mapper
```

---

## Tecnologías

- Kotlin
- Jetpack Compose
- MVVM
- Clean Architecture
- Navigation Compose
- StateFlow
- Coroutines
- Retrofit
- Room
- Mockoon
- JWT

---

## Configuración de Mockoon

1. Abrir Mockoon.
2. Importar el archivo del ambiente incluido en el proyecto.
3. Iniciar el servidor.
4. Verificar que el servicio se encuentre disponible en:

```
http://10.0.2.2:3000/
```

---

## Funcionalidades

### Login

- Inicio de sesión mediante servicio REST.
- Recepción de JWT.
- Obtención del rol desde el JWT.
- Persistencia de sesión.

### Registro

- Validación de información.
- Registro remoto mediante POST.
- Almacenamiento local en Room después de una respuesta exitosa del servidor.

### Consulta

- Consulta de registros almacenados localmente.
- Consulta de registros remotos.
