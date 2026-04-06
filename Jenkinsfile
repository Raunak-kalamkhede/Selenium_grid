pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/https://github.com/Raunak-kalamkhede/Selenium_grid.git/project.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Report') {
            steps {
                publishHTML([
                    reportDir: 'reports',
                    reportFiles: 'extent-report.html',
                    reportName: 'Test Report'
                ])
            }
        }
    }
}
