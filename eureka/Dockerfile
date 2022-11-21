#Archivo para el contenedor de la aplicación web MSapp en java 17
FROM openjdk:17-jdk-alpine
EXPOSE 8099
RUN mkdir -p /app/
ADD build/libs/eureka-0.0.1-SNAPSHOT.jar /app/eureka.jar
ENTRYPOINT [ "java", "-jar", "/app/eureka.jar" ]