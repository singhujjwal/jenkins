public SlaveTemplate(
        String ami, 
        String zone, 
        SpotConfiguration spotConfig, 
        String securityGroups, 
        String remoteFS,
        InstanceType type,
        boolean ebsOptimized, 
        String labelString, 
        Node.Mode mode, 
        String description, 
        String initScript,
        String tmpDir, 
        String userData, 
        String numExecutors,
        String remoteAdmin, 
        AMITypeData amiType, 
        String jvmopts,
        boolean stopOnTerminate, 
        String subnetId, 
        List<EC2Tag> tags, 
        String idleTerminationMinutes,
        boolean usePrivateDnsName, 
        String instanceCapStr, 
        String iamInstanceProfile, 
        boolean deleteRootOnTermination,
        boolean useEphemeralDevices, 
        boolean useDedicatedTenancy, 
        String launchTimeoutStr, 
        boolean associatePublicIp,
        String customDeviceMapping, 
        boolean connectBySSHProcess, 
        boolean connectUsingPublicIp) {
        this(ami, zone, spotConfig, securityGroups, remoteFS, type, ebsOptimized, labelString, mode, description, initScript,
                tmpDir, userData, numExecutors, remoteAdmin, amiType, jvmopts, stopOnTerminate, subnetId, tags,
                idleTerminationMinutes, usePrivateDnsName, instanceCapStr, iamInstanceProfile, deleteRootOnTermination, useEphemeralDevices,
                useDedicatedTenancy, launchTimeoutStr, associatePublicIp, customDeviceMapping, connectBySSHProcess,
                connectUsingPublicIp, false, false);
    }

    public SlaveTemplate(String ami, String zone, SpotConfiguration spotConfig, String securityGroups, String remoteFS,
            InstanceType type, boolean ebsOptimized, String labelString, Node.Mode mode, String description, String initScript,
            String tmpDir, String userData, String numExecutors, String remoteAdmin, AMITypeData amiType, String jvmopts,
            boolean stopOnTerminate, String subnetId, List<EC2Tag> tags, String idleTerminationMinutes,
            boolean usePrivateDnsName, String instanceCapStr, String iamInstanceProfile, boolean useEphemeralDevices,
            boolean useDedicatedTenancy, String launchTimeoutStr, boolean associatePublicIp, String customDeviceMapping,
            boolean connectBySSHProcess) {
        this(ami, zone, spotConfig, securityGroups, remoteFS, type, ebsOptimized, labelString, mode, description, initScript,
                tmpDir, userData, numExecutors, remoteAdmin, amiType, jvmopts, stopOnTerminate, subnetId, tags,
                idleTerminationMinutes, usePrivateDnsName, instanceCapStr, iamInstanceProfile, false, useEphemeralDevices,
                useDedicatedTenancy, launchTimeoutStr, associatePublicIp, customDeviceMapping, connectBySSHProcess, false);
    }

    public SlaveTemplate(String ami, String zone, SpotConfiguration spotConfig, String securityGroups, String remoteFS,
            InstanceType type, boolean ebsOptimized, String labelString, Node.Mode mode, String description, String initScript,
            String tmpDir, String userData, String numExecutors, String remoteAdmin, AMITypeData amiType, String jvmopts,
            boolean stopOnTerminate, String subnetId, List<EC2Tag> tags, String idleTerminationMinutes,
            boolean usePrivateDnsName, String instanceCapStr, String iamInstanceProfile, boolean useEphemeralDevices,
            boolean useDedicatedTenancy, String launchTimeoutStr, boolean associatePublicIp, String customDeviceMapping) {
        this(ami, zone, spotConfig, securityGroups, remoteFS, type, ebsOptimized, labelString, mode, description, initScript,
                tmpDir, userData, numExecutors, remoteAdmin, amiType, jvmopts, stopOnTerminate, subnetId, tags,
                idleTerminationMinutes, usePrivateDnsName, instanceCapStr, iamInstanceProfile, useEphemeralDevices,
                useDedicatedTenancy, launchTimeoutStr, associatePublicIp, customDeviceMapping, false);
    }

    /**
     * Backward compatible constructor for reloading previous version data
     */
    public SlaveTemplate(String ami, String zone, SpotConfiguration spotConfig, String securityGroups, String remoteFS,
            String sshPort, InstanceType type, boolean ebsOptimized, String labelString, Node.Mode mode, String description,
            String initScript, String tmpDir, String userData, String numExecutors, String remoteAdmin, String rootCommandPrefix,
            String slaveCommandPrefix, String slaveCommandSuffix, String jvmopts, boolean stopOnTerminate, String subnetId, List<EC2Tag> tags, String idleTerminationMinutes,
            boolean usePrivateDnsName, String instanceCapStr, String iamInstanceProfile, boolean useEphemeralDevices,
            String launchTimeoutStr) {
        this(ami, zone, spotConfig, securityGroups, remoteFS, type, ebsOptimized, labelString, mode, description, initScript,
                tmpDir, userData, numExecutors, remoteAdmin, new UnixData(rootCommandPrefix, slaveCommandPrefix, slaveCommandSuffix, sshPort),
                jvmopts, stopOnTerminate, subnetId, tags, idleTerminationMinutes, usePrivateDnsName, instanceCapStr, iamInstanceProfile,
                useEphemeralDevices, false, launchTimeoutStr, false, null);
    }