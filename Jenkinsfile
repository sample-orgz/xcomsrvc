pipeline {
   agent any

   environment {
     // You must set the following environment variables
     // ORGANIZATION_NAME
     // YOUR_DOCKERHUB_USERNAME (it doesn't matter if you don't have one)

     SERVICE_NAME = "xcomsrvc"
     REPOSITORY_TAG="${DOCKERHUB_USERNAME}/${ORGANIZATION_NAME}-${SERVICE_NAME}:${BUILD_ID}"
   }

   stages {
      stage('Preparation') {
         steps {
            cleanWs()
            git credentialsId: 'GitHub', url: "https://github.com/${ORGANIZATION_NAME}/${SERVICE_NAME}"
         }
      }
      stage('Build') {
         steps {
            //sh '''mvn clean package'''
            sh '''./gradlew clean build'''
            sh 'cp build/libs/xcomsrvc-0.0.1-SNAPSHOT.jar docker/'
         }
      }

      stage('Build and Push Image') {
         steps {
           sh 'cd docker'  
           sh 'docker image build -t ${REPOSITORY_TAG} .'
         }
      }

      stage('Deploy to Cluster') {
          steps {
                    sh 'envsubst < ${WORKSPACE}/xcomsrvc-deploy.yaml | kubectl apply -f -'
          }
      }
   }
}