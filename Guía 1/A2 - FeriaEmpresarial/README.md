# Actividad 2 - Feria Empresarial - Programación Orientada por Objetos básica en Java
Esta carpeta contiene el codigo escrito para la Actividad #2 de la Guía #1, Feria Empresarial. Este contiene los archivos `.java` necesarios para ser importado a cualquier IDE ademas de un archivo ejecutable.

## Ejecución
En la terminal de su elección, dirijase a la ubicación del proyecto en su sistema y ejecute el comando:
``` bash
java -jar .\jar\FeriaEmpresarial.jar
```

## Descripción
El programa esta diseñado con los siguientes Menus...

### Menu principal
- [1] Empresas
- [2] Stands
- [3] Visitantes
- [4] Reportes
- [0] Salir

### Menu de Empresas
- [1] Listar
    - Listar las empresas registradas
- [2] Registrar
    - Registrar una nueva empresa
- [3] Editar
    - Editar una empresa
- [4] Eliminar
    - Eliminar una empresa
- [0] Menú Principal

### Menu de Stands
- [1] Listar
    - Listar los Stands registrados
- [2] Crear
    - Crear un Stand
- [3] Eliminar
    - Eliminar un Stand
- [4] Asignar empresa
    - Asignar empresa a un Stand
- [5] Calificar
    - Calificar un Stand
        - Esta funcionalidad permite que un visitante haga una reseña de un Stand
- [0] Menú Principal

### Menu de Visitantes
- [1] Listar
    - Listar los visitantes registradas
- [2] Registrar
    - Registrar un nuevo visitante
- [3] Editar
    - Editar un visitante
- [4] Eliminar
    - Eliminar un visitante
- [0] Menú Principal

### Menu de Reportes
- [1] Listar empresas y sus stands
    - Genera un reporte con las empresas registradas y los Stands en los cuales estan asignadas.
- [2] Listar visitantes y stands visitados.
    - Genera un reporte con todas las reseñas realizadas a un Stand y la información del visitante que la realizo.
- [0] Menú Principal