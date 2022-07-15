function a(){
	console.log(" function a()");
}
 function b(){
	console.log(" function b()");
}
 function demo(op){
	console.log("this os from demo() function");
	op();
	console.log("----------------------");
}
demo(a);
demo(b);
