class Person {
    String name;
    def pretty = { "My name is $name"}
    String toString() {
        pretty()
    }
}

class Thing {
    String name
}

def p = new Person(name: 'Ujjwal')
def t = new Thing(name: 'Teapot')

assert p.toString() == "My name is Ujjwal"
p.pretty.delegate = t



