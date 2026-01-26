pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build & Test') {
            steps {
                sh '''
          chmod +x mvnw
          ./mvnw clean test
        '''
            }
        }
    }
}
