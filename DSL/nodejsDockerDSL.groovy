job('App-Nodejs-Docker-DSL') {
    description('Aplicación Node JS Docker DSL para el curso de Jenkins y run.sh')
    scm {
        git('https://github.com/morgadodesarrollador/Jenkins.git', 'rama-appnodejs'){ node -> 
            node / gitConfigName('morgadodesarrollador')
            node / gitConfigEmail('morgadodesarrollador@gmail.com')
        }
    }
    triggers {
      //  scm('H/7 * * * *')
        githubPush()
    }
    wrappers {
        nodejs('nodejs')
    }
    steps {
        dockerBuildAndPublish {
            repositoryName('morgadoberruezo/appnodejs')
            tag('${GIT_REVISION,length=7}')
            registryCredentials('docker-hub')
            forcePull(false)
            createFingerprints(false)
            skipDecorate()
        }
     //   shell("bash run.sh")
    }/*
    publishers {
	    slackNotifier {
            notifyAborted(false)
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
    }*/
}