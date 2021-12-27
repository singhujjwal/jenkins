@Library('ujjwal-devops-library') _

pipeline {
    agent any

    //AwsAccount.values().collect { it.name() }
        
    parameters
    {
        choice(
        name: 'ACCOUNT_NAME',
        choices:  ['dev', 'qa', 'staging'],
        description: 'Environments to use'
        )
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