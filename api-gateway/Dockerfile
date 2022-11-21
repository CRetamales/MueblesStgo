#Archivo para el contenedor de la aplicación web MSapp en java 17
FROM openjdk:17-jdk-alpine
EXPOSE 8080
RUN mkdir -p /app/
ADD build/libs/api-gateway-0.0.1-SNAPSHOT.jar /app/api-gateway.jar
ENTRYPOINT [ "java", "-jar", "/app/api-gateway.jar" ]