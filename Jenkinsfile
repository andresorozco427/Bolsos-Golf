pipeline {
   agent any
   
   options {
       buildDiscarder(logRotator(numToKeepStr: '3'))
       disableConcurrentBuilds()
   }
   
    stages{
       stage('Checkout') {
           steps{ 
               echo "------------>Checkout<------------"
               checkout([$class: 'GitSCM',
                        branches: [[name: '*/master']],
                        doGenerateSubmoduleConfigurations: false,
                        extensions: [],
                        gitTool:'Git_Centos',
                        submoduleCfg: [],
                        userRemoteConfigs: [[url:'https://github.com/andresorozco427/Bolsos-Golf']]])
           }  
       }
       stage('Unit Tests') {
           steps{
               echo "------------>Unit Tests<------------"
               sh 'gradle --b ./infraestructura/build.gradle test'
               sh 'gradle --b ./aplicacion/build.gradle test'
               sh 'gradle --b ./dominio/build.gradle test'
           }
       }
       stage('Integration Tests') {
           steps {
               echo "------------>Integration Tests<------------"
           }
       }
   
       stage('Build') {
           steps {
               echo "------------>Build<------------"
               sh 'gradle --b ./infraestructura/build.gradle build -x test'
               sh 'gradle --b ./aplicacion/build.gradle build -x test'
               sh 'gradle --b ./dominio/build.gradle build -x test'
           } 
       }
   }
 
	   post {
	         always {
	             echo 'This will always run'
	         }
	         success {
	             echo 'This will run only if successful'
	             junit '**/build/test-results/test/*.xml'
	         }
		         failure {
	 		echo 'This will run only if failed' 
	 		mail (to: 'andres.orozco@ceiba.com.co',subject: "Failed Pipeline:${currentBuild.fullDisplayName}",
	 		body: "Something is wrongwith ${env.BUILD_URL}")
	 		}
		 }
	       
  }