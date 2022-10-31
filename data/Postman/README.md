# Postman 

Este es un apartado para correr los tests de Postman. 

## Instalación

Para correr los tests de Postman, es necesario tener instalado [Postman](https://www.postman.com/downloads/).

## Ejecución

Para ejecutar los tests de Postman, se abre una terminal que tenga el comando sh y curl, de esta manera, dependiendo
del microservicio que se quiera probar, se ejecuta el siguiente comando:

```sh  nombre_del_microservicio.sh ```

## Ejemplo

```sh  employee.sh ```

## Resultado

El resultado de la ejecución de los tests de Postman, se puede ver en la terminal, en la cual se ejecutó el comando, 
y en los archivos de salida que se generan en la carpeta data\Postman\nombre_del_microservicio\test_xxx.json

## Archivos de salida

Los archivos de salida corresponden a los test que se ejecutaron, su formato es en json y su estructura corresponde a 
al microservicio que se está probando.

# Cómo agregar un nuevo test

Para agregar un nuevo test, se debe crear un nuevo archivo .sh en la carpeta data\Postman, el cual debe tener el
las lineas de comando que corresponden a la ejecución de los tests de Postman, y el nombre del archivo debe ser el
nombre del microservicio que se está probando. 
