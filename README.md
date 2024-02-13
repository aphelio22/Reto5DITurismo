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
@GetMapping("/gastronomia"), obtiene todos los platos gastronómicos.
@GetMapping("/gastronomia/id/{id}"), obtiene un plato gastronómico por su id.
@GetMapping("/gastronomia/origen/{origen}"), obtiene un plato gastronómico por su origen.
@GetMapping("/gatronomia/nombre/{nombre}"), obtiene un plato gastronómico por su nombre.
@PostMapping("/gastronomia/post"), introduce un nuevo plato gastronómico en la Base de Datos.
@PutMapping("/gastronomia/put/{id}"), actualiza un nuevo plato gastronómico en la Base de Datos.
@DeleteMapping("/gastronomia/delete/{id}"), elimina un plato gastronómico de la Base de Datos.






