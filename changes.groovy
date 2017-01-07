import hudson.model.*
import hudson.util.*
import hudson.scm.*


def changeSet= build.getChangeSet()
List items = changeSet.getItems()
def affectedFiles = items.collect { it.paths }
def fileNames = affectedFiles.flatten().findResults
{
       it.path
}.sort().unique()

env.PRINT_CHANGES_LIST = fileNames.join(" ")
println env.PRINT_CHANGES_LIST
