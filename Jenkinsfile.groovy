pipeline {
    agent any
    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "MAVEN"
    }
        environment {
        NEXUS_VERSION = "nexus3"
        NEXUS_PROTOCOL = "http"
        NEXUS_URL = "192.168.33.10:8081"
        NEXUS_REPOSITORY = "deployRepo"
        NEXUS_CREDENTIAL_ID = "nexus-user-credentials"
        DOCKER_HUB = "dockerhub-user-credentials"
        dockerImage = ''
        registry = "wassimslim/achat"
        
            }

        post {
        always {
            emailext body: 'A Test EMail', recipientProviders: [[$class: 'DevelopersRecipientProvider'], [$class: 'RequesterRecipientProvider']], subject: 'Test'
        }
    }

   }

