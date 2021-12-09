pipeline {
  agent any
  tools{
     jdk 'java11'
  }
  stages{
    stage('build'){
      steps{
        sh 'mvn clean install'
      }
    }
  }
}
