var s1="Wissen";
var s2="Technology";
var promise =new Promise(
	   function(resolve,reject){
	       if( (s1+s2)=== "WissenTechnology" )
	       		resolve("got you");
	       	else
	       		reject("sorry bhai");
	    }
	)
	.then(//then is for either promise is resolved or rejected
			(val)=>{//if resolved
				console.log("best place to work " +val);
				val="second then"+val;
				return val;//use return to pass value from one then to another
			},
			(val)=>{//if rejected
				console.log("miss spelled "+ val);
				//throw new Error("Port no was not available")
			}
	)
	.then(//then is for either promise is resolved or rejected
			(val)=>{//if resolved
				console.log("best place to work again " +val);
			},
			(val)=>{//if rejected
				console.log("miss spelled again ");
				//throw new Error("Port no was not available")
			}
	)
	.catch( //if some error or exceptions occured
          (err)=>{
          	console.log("error or exceptions occured");
          	console.log(err.message);
          }

	)
	.finally(
		()=>{
			console.log("always gets executed");
		}

	)
console.log("I am not waiting ");
console.log("for the execution");

