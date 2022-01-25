job('prueba2-Job-DSL'){
  
  description('Job DSL de ejemplo para Jenkins')
  scm{
    git('https://github.com/morgadodesarrollador/Jenkins.git', 'master'){ node -> 
        node / gitConfigName('morgadodesarrollador')
        node / gitConfigEmail('morgadodesarrollador@gmail.com')
    }
    
  }
  parameters{
  	stringParam ('nombre', defaultValue='Jenkins', description='parámetro cadena en el job hijo')
    booleanParam('agente', true)
    choiceParam('planetas', ['Venus', 'Marte', 'Tierra (default)', 'Jupiter', 'Saturno'. 'Urano'])
  }
  triggers{
    githubPush()
  }
  
  steps {
    shell("bash ./DSL/scripts/job.sh")
  }
  
  publishers {
  	mailer('morgadoberruezo@gmail.com', true, true) 
    slackNotifier{
    	notifyAborted(true)
      	notifyEveryFailure(true)
      	notifyNotBuilt(false)
    	  notifyUnstable(false)
      	notifyBackToNormal(true)
      	notifySuccess(false)
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