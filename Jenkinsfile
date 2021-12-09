pipeline {
  agent any
  tools{
     jdk 'java11'
     maven 'maven_3.8.x'
  }
  stages{
    stage('build'){
      steps{
        sh 'mvn clean install'
      }
    }
    stage('Build quarkus container image') {
      steps {
          echo "Build and Unit Test"
          sh "mvn -B package -Dquarkus.container-image.build=true -DskipTests=true"
      }
    }
    stage('Docker push quarkus container image') {
        steps {
            echo "Docker push quarkus container image"
            sh "mvn -B package -Dquarkus.container-image.push=true -DskipTests=true"
        }
    }
  }
}
