#Archivo para el contenedor de la aplicación web MSapp en java 17
FROM openjdk:17-jdk-alpine
EXPOSE 8081
RUN mkdir -p /app/
ADD build/libs/config-service-0.0.1-SNAPSHOT.jar /app/config-service.jar
ENTRYPOINT [ "java", "-jar", "/app/config-service.jar" ]