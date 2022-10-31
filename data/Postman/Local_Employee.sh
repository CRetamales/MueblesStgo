# Comandos de microservicio de Empleados en Local

cd Local

# Mostrar todos los empleados
curl --location --request GET 'localhost:8091/employee' --output employee-t1.json
# Mostar un empleado
curl --location --request GET 'localhost:8091/employee/1' --output employee-t2.json
#Mostrar un empleado por rut
curl --location --request GET 'localhost:8091/employee/rut/12.345.678-9' --output employee-t3.json
#Mostrar un empleado por categoria
curl --location --request GET 'localhost:8091/employee/category/C' --output employee-t4.json
#Mostrar un empleado por Fecha de nacimiento
curl --location --request GET 'localhost:8091/employee/bornDate/1990-01-01' --output employee-t5.json
# Crear un empleado
curl --location --request POST 'localhost:8091/employee' \
--data-raw '{
    "rut":"20.948.514-5",
    "names": "Patricio Arnold",
    "lastNames":"Estrella Porstang",
    "bornDate":"1956/26/05",
    "category":"A",
    "entryDate":"2015/20/10"
}'  --output employee-t6.json
# Actualizar un empleado
curl --location --request PUT '' \
--header 'Content-Type: application/json' \
--data-raw '{
    "rut":"20.948.514-5",
    "names": "Patricio Arnold",
    "lastNames":"Estrella Porstang",
    "bornDate":"1956/26/05",
    "category":"C",
    "entryDate":"2015/20/10"
}' --output employee-t7.json
# Eliminar un empleado
curl --location --request DELETE 'localhost:8091/employee/1' --output employee-t8.json
# Eliminar un empleado por rut
curl --location --request DELETE 'localhost:8091/employee/rut/12.345.678-9' --output employee-t9.json



