package org.foo
class Utilities implements Serializable {
  def steps
  Utilities(steps) {this.steps = steps}
  def mvn(args) {
    // steps.sh "${steps.tool 'Maven'}/usr/bin/mvn -o ${args}"
    steps.sh "${steps.tool 'Echo'}echo -o ${args}"
  }

  def printSomething(){
    println ("Print something function from the class")
    steps.sh "echo 'Print Something from inside the class using steps'"
  }
}
