pipeline {
    // master executor should be set to 0
    agent any
    stages {
        stage('Build Jar') {
            agent{
                anyc{
                    image 'maven:3-alpine'
                    args '-V C:/Users/admin/Desktop/.m2:/root/.m2'
                }
            }
            steps{
                bat 'mvn clean package -DskipTests'
            }
        }
        stage('Build Image') {
            steps {
                //sh
                bat "docker build -t jerry42/seleniumframework ."
            }
        }
        stage('Push Image') {
            steps {
			    withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'pass', usernameVariable: 'user')]) {
                    //sh
			        bat "docker login --username=${user} --password=${pass}"
			        bat "docker push jerry42/seleniumframework:latest"
			    }                           
            }
        }
    }
}
