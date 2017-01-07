@NonCPS
def getFilesChange(){
	def filesChange = []
	def changeLogSets = currentBuild.rawBuild.changeSets
	for (int i = 0; i < changeLogSets.size(); i++) {
		def entries = changeLogSets[i].items
		for (int j = 0; j < entries.length; j++) {
			def entry = entries[j]
			filesChange.addAll(entry.affectedFiles)
		}
	}
	return filesChange
}

def getFilesChangeAsString(){
    def filesChange = getFilesChange()
    return filesChange.join(" ")
}

return this
