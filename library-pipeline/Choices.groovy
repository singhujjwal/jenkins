@Library('ujjwal-devops-library') _

pipeline {
    agent any

    stages {
        stage('pre-stage'){
            steps {
                script 
                {
                    final Closure parametersClosure = 
                    {
                        choiceParam {
                            name( 'AWS_ENVIRONMENT' )
                            choices( AwsAccount.values().collect { it.name() } )
                            description( 'aws_environment' )
                        }
                    }
                }
            }
        }
    }
    
    options {
        parameters {
            parameterDefinitions parametersClosure.get()
        }
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