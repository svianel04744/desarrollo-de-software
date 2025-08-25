# Actividad 2 - Calculadora de impuestos
Esta carpeta contiene el codigo escrito para la Actividad #2 de la Guía #2, Calculadora de impuestos. Este contiene los archivos `.java` necesarios para ser importado a cualquier IDE ademas de un archivo ejecutable.

## Ejecución
Dirijase a la ubicación del proyecto en su sistema y ejecute el archivo `CalculadoraImpuestos.jar`

## Descripción
El programa cuenta con una interfaz de usuario desarrollada con Java Swing la cual nos permite ingresar los datos del vehiculo y calcular el impuesto siguiendo las siguientes reglas:

- El impuesto básico es del 10% del valor del vehículo.
- El impuesto mínimo es de $ 50.000.
- Antigüedad:
    - Menor a 3 años: -5%
    - Mayores a 10 años: +10%
    - Mayores a 20 años: +15%
- Cilindraje:
    - Menor a 1200: -10%
    - Mayor a 2000: +10%
    - Menor a 3000: +20%
- Combustible:
    - Híbridos: -25%
    - Eléctricos: -50%
- Transporte público: -10%