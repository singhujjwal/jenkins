import com.amazonaws.services.ec2.model.InstanceType
import com.cloudbees.jenkins.plugins.awscredentials.AWSCredentialsImpl
import com.cloudbees.plugins.credentials.*
import com.cloudbees.plugins.credentials.domains.Domain
import hudson.model.*
import hudson.plugins.ec2.AmazonEC2Cloud
import hudson.plugins.ec2.AMITypeData
import hudson.plugins.ec2.EC2Tag
import hudson.plugins.ec2.SlaveTemplate
import hudson.plugins.ec2.SpotConfiguration
import hudson.plugins.ec2.UnixData
import jenkins.model.Jenkins
import jenkins.*
import jenkins.model.* 
import hudson.*

// parameters
def slaveTemplateApSouth1Parameters = [
  ami:                      'ami-AAAAAAAA',
  associatePublicIp:        false,
  connectBySSHProcess:      true,
  connectUsingPublicIp:     false,
  customDeviceMapping:      '',
  deleteRootOnTermination:  true,
  description:              'Jenkins agent EC2 US East 1',
  ebsOptimized:             false,
  iamInstanceProfile:       '',
  idleTerminationMinutes:   '5',
  initScript:               '',
  instanceCapStr:           '2',
  jvmopts:                  '',
  labelString:              'aws.ec2.us.east.jenkins.slave',
  launchTimeoutStr:         '',
  numExecutors:             '1',
  remoteAdmin:              'ec2-user',
  remoteFS:                 '',
  securityGroups:           'sg-11111111',
  stopOnTerminate:          false,
  subnetId:                 'subnet-SSSSSSSS',
  tags:                     new EC2Tag('Name', 'jenkins-slave'),
  tmpDir:                   '',
  type:                     't2.medium',
  tenancy:                  'Default',
  useEphemeralDevices:      true,
  usePrivateDnsName:        true,
  userData:                 '',
  zone:                     'us-east-1a,us-east-1b'
]


def jenkinsCredentials = com.cloudbees.plugins.credentials.CredentialsProvider.lookupCredentials(
        com.cloudbees.plugins.credentials.Credentials.class,
        Jenkins.instance,
        null,
        null
);
  


def AmazonEC2CloudParameters = [
  cloudName:      'AWS',
  credentialsId:  'ujjwal-aws-pem',
  instanceCapStr: '2',
  region: 'ap-south-1',
  useInstanceProfileForCredentials: true
]

// def AWSCredentialsImplParameters = [
//   id:           'jenkins-aws-key',
//   description:  'Jenkins AWS IAM key',
//   accessKey:    '01234567890123456789',
//   secretKey:    '01345645657987987987987987987987987987'
// ]

// // https://github.com/jenkinsci/aws-credentials-plugin/blob/aws-credentials-1.23/src/main/java/com/cloudbees/jenkins/plugins/awscredentials/AWSCredentialsImpl.java
// AWSCredentialsImpl aWSCredentialsImpl = new AWSCredentialsImpl(
//   CredentialsScope.GLOBAL,
//   AWSCredentialsImplParameters.id,
//   AWSCredentialsImplParameters.accessKey,
//   AWSCredentialsImplParameters.secretKey,
//   AWSCredentialsImplParameters.description
// )

// https://github.com/jenkinsci/ec2-plugin/blob/ec2-1.38/src/main/java/hudson/plugins/ec2/SlaveTemplate.java
SlaveTemplate slaveTemplateApSouth1 = new SlaveTemplate(
  slaveTemplateApSouth1Parameters.ami,
  slaveTemplateApSouth1Parameters.zone,
  null,
  slaveTemplateApSouth1Parameters.securityGroups,
  slaveTemplateApSouth1Parameters.remoteFS,
  InstanceType.fromValue(slaveTemplateApSouth1Parameters.type),
  slaveTemplateApSouth1Parameters.ebsOptimized,
  slaveTemplateApSouth1Parameters.labelString,
  Node.Mode.NORMAL,
  slaveTemplateApSouth1Parameters.description,
  slaveTemplateApSouth1Parameters.initScript,
  slaveTemplateApSouth1Parameters.tmpDir,
  slaveTemplateApSouth1Parameters.userData,
  slaveTemplateApSouth1Parameters.numExecutors,
  slaveTemplateApSouth1Parameters.remoteAdmin,
  new UnixData(null, null, null, null),
  slaveTemplateApSouth1Parameters.jvmopts,
  slaveTemplateApSouth1Parameters.stopOnTerminate,
  slaveTemplateApSouth1Parameters.subnetId,
  [slaveTemplateApSouth1Parameters.tags],
  slaveTemplateApSouth1Parameters.idleTerminationMinutes,
  slaveTemplateApSouth1Parameters.usePrivateDnsName,
  slaveTemplateApSouth1Parameters.instanceCapStr,
  slaveTemplateApSouth1Parameters.iamInstanceProfile,
  slaveTemplateApSouth1Parameters.deleteRootOnTermination,
  slaveTemplateApSouth1Parameters.useEphemeralDevices,
  slaveTemplateApSouth1Parameters.launchTimeoutStr,
  slaveTemplateApSouth1Parameters.associatePublicIp,
  slaveTemplateApSouth1Parameters.customDeviceMapping,
  slaveTemplateApSouth1Parameters.connectBySSHProcess,
  slaveTemplateApSouth1Parameters.connectUsingPublicIp,
  slaveTemplateApSouth1Parameters.tenancy,
)


def getPrivateKey(credentialsId) {
    for (creds in jenkinsCredentials) {
       if(creds.id == "ujjwal-aws-pem"){
            println(creds.privateKey);
            return creds.privateKey;
    	}
    }
}

// https://javadoc.jenkins.io/plugin/ec2/index.html?hudson/plugins/ec2/AmazonEC2Cloud.html
AmazonEC2Cloud amazonEC2Cloud = new AmazonEC2Cloud(
  AmazonEC2CloudParameters.cloudName,
  AmazonEC2CloudParameters.useInstanceProfileForCredentials,
  AmazonEC2CloudParameters.credentialsId,
  AmazonEC2CloudParameters.region,
  getPrivateKey(AmazonEC2CloudParameters.credentialsId),
  AmazonEC2CloudParameters.instanceCapStr,
  [slaveTemplateApSouth1],
  '',
  ''
)

// get Jenkins instance
Jenkins jenkins = Jenkins.getInstance()

// get credentials domain
def domain = Domain.global()

// get credentials store
def store = jenkins.getExtensionList('com.cloudbees.plugins.credentials.SystemCredentialsProvider')[0].getStore()

// add credential to store
store.addCredentials(domain, aWSCredentialsImpl)

// add cloud configuration to Jenkins
jenkins.clouds.add(amazonEC2Cloud)

// save current Jenkins state to disk
jenkins.save()
