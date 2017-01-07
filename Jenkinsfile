#!groovy

node ('AWS || swarm'){
    currentBuild.result = "SUCCESS"

    try {
        stage("Checkout"){
            checkout scm
        }
 
        stage("Build"){
            def changes = load 'changes.groovy'
            println changes
            println changes.getFilesChangeAsString()
            env.FILE_CHANGES = changes.getFilesChangeAsString()
            sh 'echo $FILES_CHANGE_LIST'
        }
      
    } catch (err) {
        currentBuild.result = "FAILURE"
        throw err
  
    }
 
}
 
