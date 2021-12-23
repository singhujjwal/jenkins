//UJJWAL

@groovy.transform.Field ENV 

ENV = [      
        'DRY_RUN' : ['type': Boolean, 'required': false, 'default': true, 'description': 'Dont delete, Dry Run only'],
]

pipeline {
    agent any
    parameters {
        booleanParam(defaultValue: true, description: 'Enable DRY RUN by default', name: 'DRY_RUN')
        choice(
            name: 'DEPLOYMENT_ENVIRONMENT',
            choices: [
                'ujjwal',
                'singh'
            ],
            description: 'deployment environment'
        )
        string(defaultValue: '', description: 'AWS account region e.g. us-east-1', name: 'aws_region')
    }
    options {
        buildDiscarder(
            logRotator(
                daysToKeepStr: '60',
                artifactDaysToKeepStr: '60'
            )
        )
        disableConcurrentBuilds()
        timeout(
            time: 2,
            unit: 'HOURS'
        )
    }

    stages {
        stage('Cleanup ECR images') {
            environment {
                UNUSED = credentials("aws-${params.DEPLOYMENT_ENVIRONMENT}-creds")
            }
            steps {
                script
                {
                    if(${params.DRY_RUN} == true)
                    {
                        sh """
                        python3 pythonutils/arg_verifier.py -a xxxxxxxxxx -r ${params.aws_region} --dry-run
                        """
                    } else 
                    {
                        sh """
                        python3 pythonutils/arg_verifier.py -a yyyyyyyyyyy -r ${params.aws_region}
                        """
                    }
                }
            }
        }
    }
}