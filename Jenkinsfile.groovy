pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                bat 'build.bat'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}