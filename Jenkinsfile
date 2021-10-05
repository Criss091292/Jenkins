pipeline {
    agent any
    triggers {
        pollSCM('* * * * *')
    }
    stages {
     stage("Unit test") {
                steps {
                    sh "cd Jenkins"
                    sh "ls"
                    sh "./gradlew test"
                }
            }
        stage("Compile") {
            steps {

                sh "./Jenkins/gradlew compileJava"
            }
        }

        stage("Code coverage") {
            steps {
        	    sh "gradle jacocoTestReport"
        	 	publishHTML (target: [
         	        reportDir: 'build/reports/jacoco/test/html',
         			reportFiles: 'index.html',
         			reportName: 'JacocoReport'
         	    ])
         		sh "./Jenkins/gradlew jacocoTestCoverageVerification"
         	}
        }
        stage('SonarQube analysis') {
            steps {
                withSonarQubeEnv('SONAR800') {
                   sh "${tool name: 'SonarScanner',
                    type:'hudson.plugins.sonar.SonarRunnerInstallation'}/bin/sonar-scanner
                     -Dproject.settings=sonar-project.properties"
                }
            }
        }
    }
}