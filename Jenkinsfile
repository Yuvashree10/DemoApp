pipeline {

    agent any

    stages {

        stage('git repo & clean') {

            steps {

                script {

                    // Check if directory exists before removing it

                    if (fileExists('DemoApp')) {

                        bat "rmdir /s /q DemoApp"

                    }



                    bat "git clone https://github.com/Yuvashree10/DemoApp.git"

                    bat "mvn clean -f DemoApp"

                }

            }

        }

        stage('install') {

            steps {

                bat "mvn install -f DemoApp"

            }

        }

        stage('test') {

            steps {

                bat "mvn test -f DemoApp"

            }

        }

        stage('package') {

            steps {

                bat "mvn package -f DemoApp"

            }

        }

    }

}



def fileExists(String path) {

    try {

        fileExists = new File(path).isDirectory()

    } catch (Exception e) {

        fileExists = false

    }

    return fileExists

}