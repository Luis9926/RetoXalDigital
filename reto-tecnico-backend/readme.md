# Servicio Backend

En el servicio backend se encuentran 3 rutas principales para poder testear la aplicación: 
- /preguntas
- /vuelos
- /swagger-ui/index.html

## /swagger-ui/index.html
Esta ruta permite ver toda la documentación generada de forma automática por Swagger.
## /preguntas
Esta ruta permite ver la información de la API de StackOverflow

/preguntas
- Obtener todas las preguntas registradas.

/preguntas/contestadas-y-nocontestadas

- Obtener la cantidad de preguntas contestadas y no contestadas.

/preguntas/lista-mayor-rep

- Obtener la lista de preguntas con mas reputación.

/preguntas/mayor-rep

- Obtener la pregunta con mayor reputación.

/preguntas/menor-num-vistas

- Obtener pregunta con menor numero de vistas registadas.

/preguntas/vieja-actual

- Obtener preguna mas vieja y pregunta mas nueva.
## /vuelos
vuelo-controller

Vuelo Controller
/vuelos

- Lista de Vuelos completa

/vuelos/aerolinea-con-mas-de-2-vuelos

- Lista de aerolineas con mas de 2 vuelos

/vuelos/aerolinea-mas-ocupada

- Obtener aerolinea con mas viajes

/vuelos/aeropuerto-mas-ocupado

- Obtener aeropuerto con mas movimientos

/vuelos/dia-mas-ocupado

- Obtener fecha con mas movimientos

/vuelos/movimientos-por-aeropuerto

- Obtener lista de movimientos por aeropuerto

/vuelos/vuelos-por-aerolinea

- Obtener lista de vuelos por aerolinea

/vuelos/vuelos-por-dia

- Obtener lista de vuelos por dia

