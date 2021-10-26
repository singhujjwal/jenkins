package org.foo

def checkOutFrom(repo) {
  git url: "git@github.com:jenkinsci/${repo}"
}

def printFromInsideLibrary(){
  println ("Printing inside library.....")
}

return this