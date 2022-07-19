/*Types of for loops
for(let i=0;i<ar.length;i++){
	log(ar[i]);
}
for(let i in arr){
	console.log(i);//prints the index in menas index for understanfing
}
for(let i of arr){ //prints the values of arr
	console.log(i);
}
*/

//Callback Demo

function abc(){
	console.log("from abc() function");
}
function xyz(){
	console.log("from abc() function");
}
function demo(...op){ //Callback
	for(let i of op){ //calling all the fnctions passed as parameters in demo()
		i();
	}
	console.log("-----------------");
}
demo(abc,xyz,xyz,abc,abc,xyz,xyz,abc);
demo(abc,xyz);