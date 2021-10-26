def call(Closure body) {
    // just an example
    node('DONOTUSE') {
        body()
    }
}