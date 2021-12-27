import org.foo.AwsAccountcls
import org.foo.AzureAccountcls


List<String> getAllAccountsList() {

    final List<String> allAccountList = []
    allAccountList.add(AwsAccountcls.values())
    allAccountList.add(AzureAccountcls.values())
    return allAccountList
}
