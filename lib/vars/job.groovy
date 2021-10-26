import org.foo.Utilities

def call(
    body
) {

    println("Printed from inside the call function..")
    printFromInsideLibrary()

    def utils = new Utilities();
    utils.printSomething();
     
}
