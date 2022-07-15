var emp=["varshit",22,600000,"developer"];

function display(name,age,salary,designation){
	console.log(name);
	console.log(age);
	console.log(salary);
	console.log(name);
}
display(...emp);  //to pass single object and distribute it into multiple parameters  // (...)is spread operator

console.log("------------------------------------------------------")
function add(x,...a){  //...a should be the last parameter and can be only one ...a in the parameters
   var res=0;
   for(var i=0;i<a.length;i++){
   	res+=a[i];
   }
   console.log(res);
}
add(10,20)       //passing multiple parameters and taking them as a single paramter (...a)
add(10,20,30)
add(10)
console.log("------------------------------------------------------")


var ar1=[11,22,33,44];
var ar2=[44,55,66,77];
var ar3=[88,99];
var ar4=[...ar1,...ar2,...ar3];  //de-strucutring the 3 arrays into one single array
console.log(ar4);