#!groovy

node ('AWS || swarm'){
    currentBuild.result = "SUCCESS"

    try {
        stage("Checkout"){
            checkout scm
        }
 
        stage("Build"){
            load 'changes.groovy'
            sh 'echo $FILES_CHANGE_LIST'
        }
      
    } catch (err) {
        currentBuild.result = "FAILURE"
        throw err
  
    }
 
}
 
