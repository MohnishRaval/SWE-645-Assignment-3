pipeline {
   environment {
        registryCredential = 'dockerhub'
        TIMESTAMP = new Date().format("yyyyMMdd_HHmmss")
    }
   agent any

   stages {
    stage('Maven Clean') {
            steps {
                sh 'mvn clean'
            }
        }
        stage('Maven Install') {
            steps {
                sh 'mvn install'
            }
        }
      stage('Build Docker Image') {
         steps {
            script{
               docker.withRegistry('',registryCredential){
                  def customImage = docker.build("19982707/19982707/swe-assignment-3:${env.TIMESTAMP}")
               }
            }
         }
      }

      stage('Push Image to Dockerhub') {
         steps {
            script{
               docker.withRegistry('',registryCredential){
                  sh "docker push 19982707/19982707/swe-assignment-3:${env.TIMESTAMP}"
               }
            }
         }
      }
   }
}