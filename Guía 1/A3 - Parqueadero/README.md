# Actividad 3 - Parqueadero - Resolución de problemas usando herencia
Esta carpeta contiene el codigo escrito para la Actividad #3 de la Guía #1, Parqueadero. Este contiene los archivos `.java` necesarios para ser importado a cualquier IDE ademas de un archivo ejecutable.

## Ejecución
En la terminal de su elección, dirijase a la ubicación del proyecto en su sistema y ejecute el comando:
``` bash
java -jar .\jar\Parqueadero.jar
```

## Descripción
El programa esta diseñado con los siguientes Menus...

### Menu principal
- [1] Ingresar Vehículo
    - Permite ingresar un vehiculo al parqueadero, solicitara Marca, Modelo, Placa y dependiendo del tipo de vehiculo, Tipo de Combustible, Capacidad de Carga o Cilindraje.
- [2] Registrar Salida
    - Permite registrar la salida de un vehiculo dada su placa, ademas calcula el costo de estancia del vehiculo en el parqueadero.
    - Los Costos utilizados son (Por cada minuto en el parqueadero):
        - Automovil: $100
        - Camión: $200
        - Motocicleta: $300
- [3] Consultar estado del Parqueadero
    - Retorna una tabla con la información de todos los vehiculos en el parqueadero.
- [0] Salir