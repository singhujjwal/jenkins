

def paulMap = [
    'name' : 'Paul',
    'age' : 35,
    'address' : '123 Main St',
    'list' : [1,2,3]
];

  println("Name " + paulMap['name']);
  println("Age " + paulMap.get('age'));
  println("List Item " + paulMap['list'][1]);


paulMap.put('city', 'Pittsburgh');
 
  // Check for key
  println("Has City " + paulMap.containsKey('city'));
 
  // Size
  println("Size " + paulMap.size());



  def custs = [
    100 : "Paul",
    101 : "Sally",
    102 : "Sue"
  ];
 
  for(cust in custs){
    println("$cust.value : $cust.key ");
  }
 

 println ("I can print map " + custs)