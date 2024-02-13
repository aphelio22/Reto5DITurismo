<a name="readme-top"></a>

# ApiTurismo
## Recursos utilizados:
Para los recursos que se usarán como modelo en la aplicación se ha creado una base de datos con 4 tablas,
que se corresponden a los 4 recursos: evento, gastronomía, museo y punto de interés. Cada uno de estos con sus respectivos
atributos:

### Evento:
- id
- nombre
- precio
- direccion
- tematica
- epoca_del_anho

### Gastronomia:
- id 
- nombre 
- descripcion 
- origen

### Museo:
- id 
- nombre 
- precio 
- direccion 
- descripcion
- tematica 
- descuento

### Punto de Interés:
- id 
- nombre 
- direccion 
- descripcion

Cabe destacar que estas tablas están llenas con datos ficticios y reales. Así mismo, en la aplicación también encontraremos
los controladores referidos a cada uno de los recursos con sus respectivos EndPoints.

## EndPoints:
El controlador del recurso Evento contiene los siguientes EndPoints, partiendo de la raíz @RequestMapping("/api/turismo"):
- @GetMapping("/evento"), obtiene todos los eventos.
- @GetMapping("/evento/id/{id}"), obtiene un evento por su id.
- @GetMapping("/evento/nombre/{nombre}"), obtiene un evento por su nombre.
- @GetMapping("/evento/precio/{precio}"), obtiene todos los eventos con precio inferior al introducido.
- @GetMapping("/evento/tematica/{tematica}"), obtiene todos los eventos con una temática concreta.
- @PostMapping("/evento/post"), introuce un nuevo evento a la Base de Datos.
- @PutMapping("/evento/put/{id}"), actualiza un evento ya existente en la Base de Datos.
- @DeleteMapping("/evento/delete/{id}"), borra un evento de la Base de Datos.

El controlador del recurso Gastronomia contiene los siguientes EndPoints, partiendo de la raíz @RequestMapping("/api/turismo"):
- @GetMapping("/gastronomia"), obtiene todos los platos gastronómicos.
- @GetMapping("/gastronomia/id/{id}"), obtiene un plato gastronómico por su id.
- @GetMapping("/gastronomia/origen/{origen}"), obtiene un plato gastronómico por su origen.
- @GetMapping("/gatronomia/nombre/{nombre}"), obtiene un plato gastronómico por su nombre.
- @PostMapping("/gastronomia/post"), introduce un nuevo plato gastronómico en la Base de Datos.
- @PutMapping("/gastronomia/put/{id}"), actualiza un plato gastronómico en la Base de Datos.
- @DeleteMapping("/gastronomia/delete/{id}"), elimina un plato gastronómico de la Base de Datos.

El controlador del recurso Museo contiene los siguientes EndPoints, partiendo de la raíz @RequestMapping("/api/turismo"):
- @GetMapping("/museo"), obtiene todos los museos.
- @GetMapping("/museo/id/{id}"), obtiene un museo por su id.
- @GetMapping("/museo/nombre/{nombre}"), obtiene un museo por su nombre.
- @GetMapping("/museo/precio/{precio}"), obtiene todos los museos con un precio inferior al introducido.
- @GetMapping("/museo/tematica/{tematica}"), obtiene todos los museos con una temática concreta.
- @GetMapping("/museo/descuento/{descuento}"), obtiene todos los museos con un descuento concreto.
- @PostMapping("/museo/post"), introduce un nuevo museo en la Base de Datos.
- @PutMapping("/museo/put/{id}"), actualiza un museo en la Base de Datos.
- @DeleteMapping("/museo/delete/{id}"), elimina un museo de la Base de Datos.

El controlador del recurso Punto de Interés los siguientes EndPoints, pariendo de la raíz @RequestMapping("/api/turismo"):
- @GetMapping("/punto_interes"), obtiene todos los puntos de interés.
- @GetMapping("/punto_interes/id/{id}"), obtiene un punto de interés por su id.
- @GetMapping("/punto_interes/nombre/{nombre}"), obtiene un punto de interés por su nombre.
- @PostMapping("/punto_interes/post"), introduce un nuevo punto de interés en la Base de Datos.
- @PutMapping("/punto_interes/put/{id}"), actualiza un punto de interés en la Base de Datos.
- @DeleteMapping("/punto_interes/delete/{id}"), borra un punto de interés de la Base de Datos.

















