pipeline {
    agent any
    triggers {
        pollSCM('* * * * *')
    }
    stages {
     stage("Unit test") {
                steps {
		    sh "pwd"
                    sh "cd Jenkins"
                    sh "ls"
                    sh "./gradlew test"
                }
            }
        stage("Compile") {
            steps {
		sh "pwd"
                sh "./Jenkins/gradlew compileJava"
            }
        }

        stage("Code coverage") {
            steps {
		    sh "pwd"
        	    sh "gradle jacocoTestReport"
        	 	publishHTML (target: [
         	        reportDir: 'build/reports/jacoco/test/html',
         			reportFiles: 'index.html',
         			reportName: 'JacocoReport'
         	    ])
			sh "pwd"
         		sh "./Jenkins/gradlew jacocoTestCoverageVerification"
         	}
        }        
    }
}