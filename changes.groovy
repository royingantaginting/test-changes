@NonCPS
def getFilesChange() {
    def filesChange = []

    def changeLogSets = currentBuild.rawBuild.changeSets
	List items = changeLogSets.getItems()
	def affectedFiles = items.collect { it.paths }
	filesChange = affectedFiles.flatten().findResults
	{
       it.path
	}.sort().unique()

    return filesChange
}

def getFilesChangeAsString(){
    def filesChange = getFilesChange()
    return filesChange.join(" ")
}

return this
