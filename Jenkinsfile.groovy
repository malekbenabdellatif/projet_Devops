pipeline {
    agent any
    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "MAVEN"
    }
        environment {
        NEXUS_VERSION = "nexus3"
        NEXUS_PROTOCOL = "http"
        NEXUS_URL = "192.168.1.24:8081"
        NEXUS_REPOSITORY = "deployRepo"
        NEXUS_CREDENTIAL_ID = "nexus-user-credentials"
        DOCKER_HUB = "dockerhub-user-credentials"
        dockerImage = ''
        registry = "wassimslim/achat"
        DOCKER_CREDS_USR = "wassimslim"
        DOCKER_CREDS = credentials('dockerhub-user-credentials')

            }
    
   stages{


  
           stage('Docker Compose UP SPRING BOOT & MYSQL & Angular') { 
        steps{
                sh "docker-compose -f /root/springApp-mysql/docker-compose.yml up -d"
             }
    }
   }
        
      post {
        always {
            
	    emailext to: "wassim.slim@esprit.tn",
            subject: "jenkins build :${currentBuild.currentResult}: ${env.JOB_NAME}",
            body: "${currentBuild.currentResult}: Job ${env.JOB_NAME}\n More Infos can be found here : ${env.BUILD_URL}"
         }
    }
}

