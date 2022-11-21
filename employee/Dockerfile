#Archivo para el contenedor de la aplicación web MSapp en java 17
FROM openjdk:17-jdk-alpine
EXPOSE 8091
RUN mkdir -p /app/
ADD build/libs/employee-0.0.1-SNAPSHOT.jar /app/employee.jar
ENTRYPOINT [ "java", "-jar", "/app/employee.jar" ]