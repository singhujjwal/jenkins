@Library('ujjwal-devops-library') _

pipeline {
    agent none
    stages
    {
        stage('Example-Use-Global-Vars')
        {
            echo "Hello World!!!!"
        }
    }
}
