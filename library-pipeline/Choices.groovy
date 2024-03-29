@Library('ujjwal-devops-library') _


allAccountList = AllAccounts.getAllAccountsList()

pipeline {
    agent any

    //

    parameters
    {
        choice(
        name: 'ACCOUNT_NAME',
        choices:  allAccountList,
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