@Library('ujjwal-devops-library') _

pipeline {
    agent any
        
    parameters 
    {
        choice(name: 'ACCOUNT_NAME', choices: AwsAccount.values().collect { it.name() } , description: "AWS Account name")
        
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