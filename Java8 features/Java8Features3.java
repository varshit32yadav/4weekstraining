import java.util.*;
import java.time.*;
//optional class object wraps the null value around it 
//better way to handle null exception rather then putting the if-else and Exception hadling
// public class Java8Features3{
// 	public static void main(String[] args) {
// 		Integer i1=null;
// 		Integer i2=20;

// 		Optional<Integer>o1=Optional.ofNullable(i1);
// 		Optional<Integer>o2=Optional.ofNullable(i2);

// 		add(o1,o2);	
// 	}
// 	public static void add(Optional<Integer>a, Optional<Integer>b){
// 		Integer i1=a.orElse(new Integer(0));
// 		Integer i2=b.orElse(new Integer(0));//if null then assign 0
// 		System.out.println(i1+i2);
// 	}

// }
//second way
/*public class Java8Features3{
	public static void main(String[] args) {
		Integer i1=null;
		Integer i2=20;

		Integer o1=Optional.ofNullable(i1).orElse(new Integer(0));
		Integer o2=Optional.ofNullable(i2).orElse(new Integer(0));

		add(o1,o2);	
	}
	public static void add(Integer a,Integer b){
		// Integer i1=a.orElse(new Integer(0));
		// Integer i2=b.orElse(new Integer(0));//if null then assign 0
		System.out.println(a+b);
	}

}*/

//-----------------------------time and date----------

// public class Java8Features3{
// 	public static void main(String[] args) {

// 		LocalTime lt1=LocalTime.now();
// 		System.out.println(lt1);
// 		System.out.println("-------------------");

// 		LocalDate td=LocalDate.now();
// 		System.out.println(td);
// 		System.out.println("-------------------");

// 		LocalTime lt=LocalTime.now(ZoneId.of("Singapore"));
// 		System.out.println(lt);
// 		System.out.println("-------------------");

// 		LocalDateTime ltd=LocalDateTime.now();
// 		System.out.println(ltd);
// 		System.out.println("-------------------");

// 		LocalDate td1=LocalDate.of(1983,Month.SEPTEMBER,17);
// 		System.out.println(td1);
// 		System.out.println("-------------------");

// 	    Set<String> s= ZoneId.getAvailableZoneIds();
// 	    s.forEach(System.out::println);


// 	}
// }


//----------------------------------------------------------------execute JS code inside java Program--------------------------------------------
import java.io.*;
import javax.script.*;
//As Js is interpreted so you need not to compile the java program again and again when made changes in js code
public class Java8Features3{
	public static void main(String[] args) throws Exception {

		ScriptEngineManager mgr=new ScriptEngineManager();
		ScriptEngine engine=mgr.getEngineByName("JavaScript"); //eg. Nashorn engine

		engine.eval("print('Hello from the java program for JAvascript code')"); //printing js code

		engine.eval(new FileReader("abc.js")); //ones the file is loaded and then you can access it any time you want //better practise is to load all the files in start only

		System.out.println("--------------------------");

		engine.eval(new FileReader("xyz.js"));

		Invocable inv=(Invocable)engine;

		inv.invokeFunction("abc");//loaded abc() from abc file
		inv.invokeFunction("xyz");//loaded xyz() from xyz.js file

		inv.invokeFunction("add",22,11); //calling Js functon from java

		//accepting return value of the js function in java
		Object o1=inv.invokeFunction("greet","ram","lal"); 
		String str1=(String)inv.invokeFunction("greet","varshit","yadav");//by default it takes return type of js funcitons in java as object so you have to type cast accordingly;
		System.out.println(o1);
		System.out.println(str1);


	}
}