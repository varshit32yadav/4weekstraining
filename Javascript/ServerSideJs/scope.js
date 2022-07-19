

function abc(){
	x=10;      //global scope
	var y=20;  //var scope is inside the function only
console.log("inside abc()"+x);
	{
		var z=32; //even if var is inside the block ,still its scope is with in the fucntion
		let z1=32;//outside block not available [it is the block scope]
	}
console.log("X="+x);
console.log("y="+y);
console.log("Z="+z);
//console.log("Z1="+z1);//not available outside block

const a=10;
a=90;//error cant change value of constant //[added inthe ecma script]
}
abc();
console.log("X="+x);
//console.log("y="+y);//not available outside function
