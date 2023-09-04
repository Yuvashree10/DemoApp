 
   pipeline {
    agent any
    tools{
     maven 'Maven 3.5.0'
    }

    stages {
        stage('Stage') {
            steps {
             bat "mvn clean"
                echo 'Build start'
            }
        }
     stage('Build') {
            steps {
             bat "mvn install"
                echo 'Build complete'
            }
        }
    }
}


