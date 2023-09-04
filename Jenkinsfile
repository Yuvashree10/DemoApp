 
   pipeline {
    agent any
    tools{
     maven 'maven'
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


