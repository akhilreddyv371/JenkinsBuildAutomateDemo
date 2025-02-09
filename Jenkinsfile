pipeline {
    agent any

    environment {
        SONARQUBE_SERVER = 'SonarQube' // Replace with your server name
        SONAR_PROJECT_KEY = 'JenkinsDemo'    // Replace with your project key
        SONAR_AUTH_TOKEN = credentials('SonarQubeToken') // Replace with your credential ID
    }

    stages {
        stage("Checkout code"){
            steps{
                git url: "https://github.com/akhilreddyv371/JenkinsBuildAutomateDemo.git", branch: "Master"
            }
        }    
        
        stage('Checkout Code') {
            steps {
                echo 'Checking out the code...'
                checkout scm
            }
        }

        stage('Build') {
            steps {
                echo 'Building the project...'
                sh 'mvn clean package'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv(SONARQUBE_SERVER) {
                    sh '''
                        mvn sonar:sonar \
                        -Dsonar.projectKey=${SONAR_PROJECT_KEY} \
                        -Dsonar.host.url=${SONAR_HOST_URL} \
                        -Dsonar.login=${SONAR_AUTH_TOKEN}
                    '''
                }
            }
        }

        stage('Quality Gate') {
            steps {
                script {
                    timeout(time: 5, unit: 'MINUTES') {
                        def qualityGate = waitForQualityGate()
                        if (qualityGate.status != 'OK') {
                            error "Pipeline aborted due to quality gate failure: ${qualityGate.status}"
                        }
                    }
                }
            }
        }
    }
}
