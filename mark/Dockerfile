#Archivo para el contenedor de la aplicación web MSapp en java 17
FROM openjdk:17-jdk-alpine
EXPOSE 8094
RUN mkdir -p /app/
ADD build/libs/mark-0.0.1-SNAPSHOT.jar /app/mark.jar
ENTRYPOINT [ "java", "-jar", "/app/mark.jar" ]