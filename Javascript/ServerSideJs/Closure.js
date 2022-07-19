/*
scope- within the area you can access the variable
lifetime- how long till it stays..
eg. for global var lifetime and scope is till the program gets finished

*/
/*
function abc(){
	var a=0;//its scope is within the abc() and 
	//to maintain the lifetime of var a when abc() is called again and again
    var plus=function()  
	{
		a+=1;
		console.log(a);
	}
	return plus;

}
incr=abc();
incr();
incr();
*/
//second way
var incr=function abc(){ 

	var a=0;
	var plus=function()  //closure function used to use var a everytime called
	{
		a+=1;
		console.log(a);
	}
	return plus;
} ();//1  //incr is self invocation functinon


incr();//2
incr();//3