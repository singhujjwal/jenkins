package org.foo

import com.cloudbees.groovy.cps.NonCPS

enum AwsAccountcls
{
    
    k8sl000xxx,
    k8sl010yyy,
    k8sl020zzz,
    k8sl030aaa
    

    @NonCPS
    static boolean isValidAccount(){
        return true
    }

}
