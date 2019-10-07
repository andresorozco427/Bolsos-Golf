pipeline {
   //Donde se va a ejecutar el Pipeline
   agent {
       label 'Slave_Induccion'
   }
   
   //Opciones especÃƒÂ­ficas de Pipeline dentro del Pipeline
   options {
       //Mantener artefactos y salida de consola para el # especÃƒÂ­fico de ejecucionesrecientes del Pipeline.
       buildDiscarder(logRotator(numToKeepStr: '3'))
       disableConcurrentBuilds()
   }
   
   tools {
       jdk 'JDK8_Centos'
       gradle 'Gradle4.5_Centos'
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
                        userRemoteConfigs: [[url:'https://github.com/fercho2000/PARQUEAERO-CEIBA']]])
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
       stage('Static Code Analysis') {
           steps{
               echo '------------>AnÃƒÂ¡lisis de cÃƒÂ³digo estÃƒÂ¡tico<------------'
               withSonarQubeEnv('Sonar') {
                   sh "${tool name: 'SonarScanner',type:'hudson.plugins.sonar.SonarRunnerInstallation'}/bin/sonar-scanner"}
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