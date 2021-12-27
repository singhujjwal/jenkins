@Library('ujjwal-devops-library') _

pipeline {
    agent none
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
                    sayHello 'Joe'
                    sayHello()
                    job()
                }
            }
        }
    }
}
