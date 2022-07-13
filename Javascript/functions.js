var a="10";
var b=20;
var c="3-4+7*5"
console.log(a+b);//1020
console.log(parseInt(10)+20);//30
console.log(eval(c));//34

var i=0;
function start(){
	i++;
	console.log("hello"+i);

}
start()//synchrononus manual calling

//asynchronous calling
//setTimeout(abc,2000)
var ref=setInterval(start,2000)
function stop(){
	clearInterval(ref);
	console.log("thankyou all")
}
setTimeout(stop,10000)
console.log("I will not wait")