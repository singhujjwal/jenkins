import org.foo.AwsAccountcls
import org.foo.AzureAccountcls


List<String> getAllAccountsList() {
    return AwsAccountcls.values().collect { it.name() } + AzureAccountcls.values().collect { it.name() }
    return allAccountList
}
