# Drive_Lux
Sistema de punto de venta para una concesionaria de autos

## DESARROLLADORES

* ALONSO CRUZ YAHIR JIBSAM
* AGUILAR SANTIAGO GUILLERMO

## Tecnologías Usadas

* JDK 20
* NeatBens

## Funciones

* LOGIN CON ROLES (SUPERVISOR, VENDEDOR)

    Un menú principal para la administración del sistema, accesible solo por usuarios con privilegios de administrador y otro para los que tienen privilegios de vendedor.

* CRUD DE CLIENTES

    Módulo para gestionar los datos de los clientes de la concesionaria.

    Funcionalidades CRUD:
    * Crear: Registrar nuevos clientes.
    * Leer: Consultar información de clientes existentes.
    * Actualizar: Actualizar datos de clientes.
    * Eliminar: Borrar registros de clientes.

* CRUD DE EMPLEADOS

    Módulo dedicado a la gestión del personal de la concesionaria.

    Funcionalidades CRUD:
    * Crear: Añadir nuevos empleados al sistema.
    * Leer: Consultar información de empleados existentes.
    * Actualizar: Modificar datos de los empleados.
    * Eliminar: Borrar registros de empleados.
    * Genera una contraseña segura al momento de regitrarse y se envía al correo electrónico con el que el usuario se dio de alta.

* CRUD DE AUTOS

    Módulo para la administración de los vehículos disponibles en la concesionaria.

    Funcionalidades CRUD:
    * Crear: Añadir nuevos autos al inventario.
    * Leer: Consultar información de autos disponibles.
    * Actualizar: Modificar detalles de los vehículos.
    * Eliminar: Eliminar autos del inventario.

* CRUD DE MODELOS

    Módulo para la gestión de los modelos de autos disponibles en la concesionaria según la marca.

    Funcionalidades CRUD:
    * Crear: Añadir nuevos modelos al inventario.
    * Leer: Consultar información de modelos registrados.
    * Actualizar: Modificar detalles de los modelos ehículos.
    * Eliminar: Eliminar modelos del inventario.

* CRUD DE MARCAS

    Módulo para la gestión de las marcas de autos existentes en la concesionaria.
    Funcionalidades CRUD:
    * Crear: Añadir nuevas marcas al inventario.
    * Leer: Consultar información de marcas registradas.
    * Actualizar: Modificar detalles de las marcas de vehículos.
    * Eliminar: Eliminar marcas del inventario.

* SECCIÓN DE VENTAS
     
    Módulo para registrar nuevas ventas de autos.
    * Existe una tabla donde se muestran todos los autos disponibles 
    * Los autos disponibles se pueden filtrar para que solo muestren los autos con características requeridas
    * Existe una segunda tabla donde se va a agregando los autos que se quieran comprar
    * Muestra el total de la venta 
    * Para finalizar la venta existe el botón "Comprar" que hace todos los registros pertinentes

    Módulo para ver el historial de ventas
    * Muestra las ventas realizadas con anterioridad mostrando el cliente, el total y el #ID de venta