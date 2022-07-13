//types of ways to create the functions
function add1(a,b){
	console.log("add1 ="+ (a+b));
}
var add2= function(a,b){
	console.log("add2 ="+ (a+b));
}
var add3=(a,b)=>console.log("add3 ="+ (a+b));

var add4=new Function('a','b',"console.log('add4 ='+ (a+b))")//dynamically create a funcition by passing logic and values 
add1(2,3);
add2(3,4);
add3(4,5);
add4(5,6);
