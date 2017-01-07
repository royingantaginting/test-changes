#!groovy

node ('AWS || swarm'){
    currentBuild.result = "SUCCESS"

    try {
        stage("Checkout"){
            checkout scm
        }
 
        stage("Build"){
            def changes = load 'changes.groovy'
            env.FILES_CHANGE = changes.getFilesChangeAsString()
            sh 'echo $FILES_CHANGE'
        }
      
    } catch (err) {
        currentBuild.result = "FAILURE"
        throw err
  
    }
 
}
 
