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
  }
}
