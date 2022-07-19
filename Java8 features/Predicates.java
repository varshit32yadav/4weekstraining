import java.util.function.Predicate;  //way better then if-else as it saves lot of lines of code

/*Predicate return type is boolean*/

public class Predicates{
	public static void main(String[] args) {
		int[] ar={11,22,33,44,55,66,77,88,99,-110,-121};
		Predicate<Integer> p1=(x)->(x%2)==0; //even numbers
		process(ar,p1);

		Predicate<Integer> p11=(x)->(x%2)==0; //or
		process(ar,p1.negate());              //odd numbers

		Predicate<Integer>p2=(x)->(x>50);  //above 50
		process(ar,p2);

		process(ar,p2.negate()); //below 50

		process(ar,p2.and(p1));//above 50 and even numbers

		process(ar,p2.and(p1.negate())); //above 50 and odd numbers

		process(ar,p1.negate().and(p2.negate())); //below 50 and odd numbers

		Predicate<Integer>p3=(x)->(x>0);  //all positive  numbers;
		process(ar,p3);
		process(ar,p1.negate().and(p3.negate()));//all odd and negative

	}
	public static void process(int[] ar,Predicate<Integer>p ){
           
           for(int i:ar){
           	if(p.test(i)) System.out.println(i);
           }
           System.out.println("----------------------");
	}
}