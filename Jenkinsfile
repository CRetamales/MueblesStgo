//Archivo Jenkinsfile para el pipeline de Jenkins
pipeline {
    agent any //Ejecutar en cualquier nodo
    tools {
        maven 'maven' //Usar Maven
    }
    stages {
        stage('Build JAR File') {
            steps {
                // Se obtiene el código fuente
                echo 'Obteniendo el código fuente'
                checkout([$class: 'GitSCM', branches: [[name: '*/master'], [name: '*/develop']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/CRetamales/MueblesStgo']]])
                echo 'Compilando el código fuente con Maven'
                echo 'Microservico Config Server'
                dir('config-server') {
                    sh 'mvn clean install -DskipTests'
                }
                echo 'Microservico Eureka Server'
                dir('eureka') {
                    sh 'mvn clean install -DskipTests'
                }
                echo 'Microservico api-gateway'
                dir('api-gateway') {
                    sh 'mvn clean install -DskipTests'
                }
                echo 'Microservico employee'
                dir('employee') {
                    sh 'mvn clean install -DskipTests'
                }
            }
        }
        stage('Test'){
            steps{
                echo 'Ejecutando pruebas unitarias'
            }
        }
        stage('Build Docker Image'){
            steps{
                echo 'Construyendo imagen Docker'
                echo 'Microservico Config Server'
                dir('config-server') {
                    sh 'docker build -t cfretamales/config-server .'
                }
                echo 'Microservico Eureka Server'
                dir('eureka') {
                    sh 'docker build -t cfretamales/eureka .'
                }
                echo 'Microservico api-gateway'
                dir('api-gateway') {
                    sh 'docker build -t cfretamales/api-gateway .'
                }
                echo 'Microservico employee'
                dir('employee') {
                    sh 'docker build -t cfretamales/employee .'
                }
            }

        }
    }
}