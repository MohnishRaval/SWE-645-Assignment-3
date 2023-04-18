pipeline {
    environment {
        registryCredential = 'dockerhub'
        TIMESTAMP = new Date().format("yyyyMMdd_HHmmss")
    }
    agent any
    stages{
        stage('Build Maven'){
            script{
                steps{
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/MohnishRaval/SWE-645-Assignment-3']]])
                sh 'mvn clean install'
            }
          }  
        }
        stage('Build docker image'){
            script{
                steps{
                 docker.withRegistry('',registryCredential){
                  def customImage = docker.build("19982707/swe-assignment-3:${env.TIMESTAMP}")
               }
            }
            }    
        }
        stage('Push Image to Dockerhub') {
         steps {
            script{
               docker.withRegistry('',registryCredential){
                  sh "docker push 19982707/swe-assignment-3:${env.TIMESTAMP}"
               }
            }
         }
      }
    }
}