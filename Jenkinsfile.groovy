pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                git.exe log
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