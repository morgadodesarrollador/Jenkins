job('App-Nodejs-DSL') {
    description('Aplicación Node JS DSL para el curso de Jenkins')
    scm {
        git('https://github.com/morgadodesarrollador/Jenkins.git', 'master'){ node -> 
            node / gitConfigName('morgadodesarrollador')
            node / gitConfigEmail('morgadodesarrollador@gmail.com')
            extensions {
                sparseCheckoutPath {
                    path('AppNodeJS')
                }
            }
        }
    }
    triggers {
        scm('H/7 * * * *')
    }
    wrappers {
        nodejs('nodejs')
    }
    steps {
        shell("bash AppNodeJS/install.sh")
    }
    publishers {
	    slackNotifier {
            notifyAborted(true)
            notifyEveryFailure(true)
            notifyNotBuilt(false)
            notifyUnstable(false)
            notifyBackToNormal(true)
            notifySuccess(true)
            notifyRepeatedFailure(false)
            startNotification(false)
            includeTestSummary(false)
            includeCustomMessage(false)
            customMessage(null)
            sendAs(null)
            commitInfoChoice('NONE')
            teamDomain(null)
            authToken(null)
        }
    }
}