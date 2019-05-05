
node {
  stage('checkout sources') {
        // You should change this to be the appropriate thing
        git url: 'https://github.com/Synergy232/Special_Topics_Lab_V'
  }

  stage('Build') {
    withMaven (maven: 'maven3') {
              sh "mvn package"
            }
    echo "hello"
  }
  pipeline {
      agent any
      stages {
          stage('Build') {
              steps {
                  sh './gradlew build'
              }
          }
          stage('Test') {
              steps {
                  sh './gradlew check'
              }
          }
      }

      post {
          always {
              archiveArtifacts artifacts: 'build/libs/**/*.jar', fingerprint: true
              junit 'build/reports/**/*.xml'
          }
      }
  }
}
