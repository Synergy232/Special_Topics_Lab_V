pipelineJob('build-pipeline-job') { 

  // This is the repo that contains the Jenkinsfile you want to use to define your pipeline
  def repo = 'https://github.com/Synergy232/Special_Topics_Lab_V'

  description("Your App Pipeline") 
  keepDependencies(false) 

  properties{ 
    githubProjectUrl (repo) 
    rebuild { 
      autoRebuild(false) 
    } 
  } 

  definition { 
    cpsScm { 
      scm { 
        git { 
          remote { url(repo) } 
          branches('So_i_can_do_a_pull_request_because_i_messed_up_at_the_start') 
          scriptPath('Jenkinsfile') // The location of the Jenkinsfile that defines the pipeline job within the repo
          extensions { }  // required as otherwise it may try to tag the repo, which you may not want 
        } 
      } 
    } 
  }
}
