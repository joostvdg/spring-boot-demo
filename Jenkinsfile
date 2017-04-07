pipeline {
  agent {
    docker {
      image 'gradle:jdk8-alpine'
    }
    
  }
  stages {
    stage('') {
      steps {
        sh 'gradle clean build'
      }
    }
    stage('Finish') {
      steps {
        archiveArtifacts(fingerprint: true, onlyIfSuccessful: true, allowEmptyArchive: true, artifacts: 'build/libs/spring-boot-demo-1-*.jar')
      }
    }
  }
}