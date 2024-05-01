# Conversor de Monedas

Este proyecto es un conversor de monedas que permite al usuario convertir entre diferentes tipos de monedas.

## Clases

### `Principal`

Esta es la clase principal que inicia la aplicación. Crea una instancia de `MenuConversionMonedas` y llama al método `menu()` para iniciar la interacción con el usuario.

### `MenuConversionMonedas`

Esta clase maneja la interacción con el usuario. Muestra un menú de opciones al usuario y maneja su elección. Cada opción del menú está manejada por un método separado (por ejemplo, `manejarOpcion1()`, `manejarOpcion2()`, etc.). También inicializa la lista de monedas disponibles para la conversión.

### `ConversorMonedas`

Esta clase se encarga de la lógica de conversión de monedas. Tiene un método `ConvertirMoneda()` que toma como parámetros la moneda de origen, la moneda de destino y la cantidad a convertir, y devuelve el resultado de la conversión.
>Esta clase tien una lista `registroConversion` que almacena objetos de la clase `HistorialRevisiones`
>obtiene  las tasas de conversion de la API con el metodo `getConversionRates` de la clase `JsonParserService`
>verifica que la monde de destino este diponible.

>Obtiene las tasas de converion de la moneda de origen y la moneda de destino, calcula el resultado y tiene un formato de 3 decilames.
>se acrea un nuevo objeto `HistorialRevisiones` con los detalles de la conversiony lo añade a la lista
### `Moneda`

Esta es una clase modelo que representa una moneda. Tiene tres atributos: el código de la moneda (por ejemplo, "USD"), el nombre de la moneda (por ejemplo, "United States Dollar") y el país de la moneda (por ejemplo, "United States").

### `ApiService`

Esta clase se encarga de hacer llamadas a una API externa para obtener las tasas de conversión de monedas. Tiene un método `getConversionRates` devuelve la tasa de conversión.
> La clase tien una URL que es la base de la API
> crea un URI apartir de la URL base de la API y el codigo de orign de la monedas
> crea un cliente HttpClient y un HttpReques con el URI.

### `JsonParserService`

Esta clase se encarga de analizar la respuesta JSON de la API externa. Tiene un método `parseConversionRates` que toma como parámetro una cadena JSON y devuelve un objeto `JsonObject` que contiene las tasas de conversión de monedas.
>Utiliza el metodo parseString(json) de la clase JsonParser para convertir la cadena JSON

### `HistorialRevisiones`

Esta clase se encarga de mantener un historial de las conversiones de monedas realizadas por el usuario.
>tiene sobrescrito el metodo `toString` para que muestre el historial de revisiones en cierto formato. 

## Cómo usar

Para usar este conversor de monedas, simplemente ejecute la clase `Principal`. Se le presentará un menú de opciones. Elija la opción que desee ingresando el número correspondiente. Si elige una opción de conversión de monedas, se le pedirá que ingrese la cantidad a convertir. El resultado de la conversión se mostrará en la consola.

## Ejemplo de ejecucion

![image](https://github.com/tubis01/Challenge_ConversorMonedaAPI/assets/115319646/11314052-a057-4aab-a561-c34166a667d1)

>Podemos observar que la opcion "7. Otra conversion(Seleccionar moneda de origen y destino. Esta opcion nos mostrala un listado de todas las monedas disponibles para conversoin y solamente debemos indicar el numero de la moneda que queremos selccionar

![image](https://github.com/tubis01/Challenge_ConversorMonedaAPI/assets/115319646/af54cc7a-7805-4578-bf39-01854e195f1e)

Respueta para una de las primera opciones predeterminadas de la moneda 

### seleccionamos la moneda de origen para la opcion numero 7 
![image](https://github.com/tubis01/Challenge_ConversorMonedaAPI/assets/115319646/4628cdec-bf0e-4d68-adb3-00a3fb12a323)
### seleccionamos la moneda de destino para la opcion numero 7 
![image](https://github.com/tubis01/Challenge_ConversorMonedaAPI/assets/115319646/df0b79fe-ec41-4144-9f94-0a352268a5c0)
>Ingresamos la cantidad que deseamos convertir y nos retorna el resultado.
>

### historial de revisiones 
![image](https://github.com/tubis01/Challenge_ConversorMonedaAPI/assets/115319646/e3492739-d037-4bdf-96fc-9d219fadb715)
>Podemos observar la fecha, moneda de origen, moneda destino y el resultado, los datos que nos mostrara nuestro historial 
