job('App-Nodejs-Docker-DSL') {
    description('Aplicación Node JS Docker DSL para el curso de Jenkinsss')
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
    }
}