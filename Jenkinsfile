pipeline {
    agent any
    stages {
        stage('Checkout Code') {
            steps {
                git 'https://github.com/amitnvgm/PracticeAutomation.git'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('Run Tests') {
            steps {
                sh 'mvn test'
            }
        }
        stage('Publish Reports') {
            steps {
                publishHTML(target: [reportDir: 'target/surefire-reports', reportFiles: 'index.html'])
            }
        }
    }
}
