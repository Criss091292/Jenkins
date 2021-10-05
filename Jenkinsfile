pipeline {
    agent any
    triggers {
        pollSCM('* * * * *')
    }


    stages {
     stage("Unit test") {
	when {
       		not {
          		anyOf {
            			branch 'master';
            			branch 'staging'
          		}
       		}
   	}
                steps {
		    sh "pwd"
                    sh "cd ../JenkinsSofka"
                    sh "ls"
                    sh "./gradlew test"
                }
            }
        stage("Compile") {
	when {
       		not {
          		anyOf {
            			branch 'master';
            			branch 'staging'
          		}
       		}
   	}
            steps {
	when {
       		not {
          		anyOf {
            			branch 'master';
            			branch 'staging'
          		}
       		}
   	}
		sh "pwd"
                sh "../JenkinsSofka/gradlew compileJava"
            }
        }

        stage("Code coverage") {
	when {
       		not {
          		anyOf {
            			branch 'master';
            			branch 'staging'
          		}
       		}
   	}
            steps {
		    sh "pwd"
        	    sh "gradle jacocoTestReport"        	 	
		    sh "pwd"
        	    sh "../JenkinsSofka/gradlew jacocoTestCoverageVerification"
         	}
        }        
    }
}