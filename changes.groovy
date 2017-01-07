@NonCPS
def getFilesChange(){
	def filesChange = []
	def changeLogSets = currentBuild.rawBuild.changeSets
	for (int i = 0; i < changeLogSets.size(); i++) {
		def entries = changeLogSets[i].items
		for (int j = 0; j < entries.length; j++) {
			def entry = entries[j]
			def files = new ArrayList(entry.affectedFiles)
			for (int k = 0; k < files.size(); k++) {
				def file = files[k]
                echo "  ${file.editType.name} ${file.path}"
				filesChange.add(file.path)
			}
		}
	}
	return filesChange
}

def getFilesChangeAsString(){
    def filesChange = getFilesChange()
    return filesChange.join(" ")
}

return this
