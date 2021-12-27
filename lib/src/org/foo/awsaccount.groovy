package org.foo

import com.cloudbees.groovy.cps.NonCPS

enum AwsAccount
{
    
    k8sl000xxx,
    k8sl010yyy,
    k8sl020zzz,
    k8sl030aaa
    
    final AwsAccount accountType

    AwsAccount()
    {
        final String accountName = name()
    }   

    @NonCPS
    static boolean isValidAccount(){
        return true
    }


}
