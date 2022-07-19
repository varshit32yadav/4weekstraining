//types of wasy to traverse the list using forEach Methode which is part of Iterable interface
import java.util.*;
import java.util.function.*;
import java.lang.*;

class Cons implements Consumer<Integer>{
	public void accept(Integer i){
		System.out.println(i);
	}
}

class ConsumerInterfaceExample{
	static void printMessage(String name){
		System.out.println("From printMessage " + name);
	}
	static void printValue(int value){
		System.out.println("From printValue "+ value);
	}

	static void printList(List list){
		list.forEach(System.out::println);
	}
}

public class Java8Features2{

	public static void main(String[] args) {
		List<Integer>list=Arrays.asList(11,22,33,44,55,66,77,88);
		list.forEach(new Cons());
		
		Consumer<String>c1=ConsumerInterfaceExample::printMessage;
		c1.accept("Manoj");
		Consumer<Integer> c2=ConsumerInterfaceExample::printValue;
		 c2.accept(111);


		List<String>al=Arrays.asList("Ram","asd","shaym","asdd","kalu");

		list.forEach(ConsumerInterfaceExample::printValue);
		al.forEach(ConsumerInterfaceExample::printMessage);

		 List<List>list3=Arrays.asList(list,al);
		 list3.forEach(ConsumerInterfaceExample::printList);

    }
}


// public class Java8Features2{
// 	public static void main(String[] args) {
// 		List<Integer>list=Arrays.asList(11,22,33,44,55,66,77,88);

// 		//types of wasy to traverse the list using forEach Methode whic is part of Iterable interface

// 		Consumer<Integer> c=(x)->(System.out.println(x));
// 		list.forEach(c);
// 		System.out.println("------------------------------");
// 		list.forEach( (x)->System.out.println(x) );
// 		System.out.println("------------------------------");
// 		list.forEach( System.out::println );
// 	}
// }