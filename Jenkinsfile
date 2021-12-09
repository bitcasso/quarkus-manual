pipeline {
  agent any
  tools{
    jdk 'jdk-17'
  }
  stages{
    stage('build'){
      steps{
        sh 'mvn clean install'
      }
    }
  }
}
