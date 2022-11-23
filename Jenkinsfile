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
                echo 'Microservico mark'
                dir('mark') {
                    sh 'mvn clean install -DskipTests'
                }

            }
        }
        stage('Build Frontend React')
        {
            steps {
                echo 'Compilando el Frontend con React'
                dir('frontend') {
                    sh 'npm install'
                    //sh 'npm run build'
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
                //echo "Usuario: ${env.USER}"
                //sh 'groups'
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
                echo 'Microservico mark'
                dir('mark') {
                    sh 'docker build -t cfretamales/mark .'
                }
                echo 'Frontend con react'
                dir('frontend') {
                    sh 'docker build -t cfretamales/react .'
                }
            }
        }
        stage('Push docker image'){
            steps{
                withCredentials([string(credentialsId: 'dckrhubpassword', variable: 'dckrPass')]) {
                    sh 'docker login -u cfretamales -p ${dckrPass}'
                }
                echo 'Subiendo imagen Docker'
                echo 'Microservico Config Server'
                sh 'docker push cfretamales/config-server'
                echo 'Microservico Eureka Server'
                sh 'docker push cfretamales/eureka'
                echo 'Microservico api-gateway'
                sh 'docker push cfretamales/api-gateway'
                echo 'Microservico employee'
                sh 'docker push cfretamales/employee'
                echo 'Microservico mark'
                sh 'docker push cfretamales/mark'
                echo 'Frontend con react'
                sh 'docker push cfretamales/react'
            }
        }
    }
    post {
        always {
            echo 'Deslogueando de Docker Hub'
            sh 'docker logout'
        }
    }
}