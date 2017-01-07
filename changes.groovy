@NonCPS
def getChangeFiles() {
    def changeFiles = []

    def changeLogSets = currentBuild.rawBuild.changeSets
	List items = changeLogSets.getItems()
	def affectedFiles = items.collect { it.paths }
	changeFiles = affectedFiles.flatten().findResults
	{
       it.path
	}.sort().unique()

    return changeFiles
}

def getChangeFilesAsString(){
    def changeFiles = getChangeFiles()
    return changeFiles.join(" ")
}

return this
