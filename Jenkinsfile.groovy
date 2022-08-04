pipeline {
    agent any

    stages {
        stage('Test') {
            steps {
                echo 'Testing...'
                bat 'auto/test.bat'
            }
        }

        stage('Build') {
            steps {
                echo 'Building...'
                bat 'auto/build.bat'
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying...'
                bat 'auto/deploy.bat'
            }
        }
    }
}