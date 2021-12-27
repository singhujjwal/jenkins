@Library('ujjwal-devops-library') _

pipeline {
    agent any
        
    parameters 
    {
        choiceParam('ACCOUNT_NAME', AwsAccount.values().collect { it.name() })
        
    }
    stages
    {
        stage('Example-Use-Global-Vars')
        {
            steps
            {
                script
                {
                    log.info 'Starting'
                    log.warning 'Nothing to do!'
                }
            }
        }
        stage('Example-Use-built-in-step')
        {
            steps
            {
                sayHello 'Joe'
                sayHello()
            }
        }
    }
}