 
   pipeline {
    agent any
    tools{
     maven 'Maven 3.5.0'
    }

    stages {
        stage('Build') {
            steps {
             bat "mvn clean"
                echo 'Build complete'
            }
        }
    }
}


