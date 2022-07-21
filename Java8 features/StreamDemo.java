import java.util.*;
import java.util.stream.*;
import java.util.function.*;
public class StreamDemo{

	public static void main(String[] args) {
	/*           input          output
	filter 		 n              <=n
	map			 n              n
	reduce		 n              1 
	*/
		
	IntStream.rangeClosed(1,6).reduce((a,b)->a+b);  //adding all the numbers 
     
     OptionalInt reduced=IntStream.rangeClosed(1,10).reduce( (a,b)->a+b );
     System.out.println(reduced.getAsInt());
     System.out.println("--------------------------");

     int reduced2=IntStream.rangeClosed(1,3).reduce(10,(a,b)->a+b); //starting value of a is 10 i,e addtion starts from 10+b and goes on
     System.out.println(reduced2);
     System.out.println("--------------------------");

     int reduced3=Stream.of(1,2,3).reduce(10,(a,b)->a+b);
     System.out.println(reduced3);
     System.out.println("--------------------------");

     int reduced4 = Arrays.asList(1,2,3,4).parallelStream().reduce(10,(a,b)->a+b, (a,b)-> a+b); //to execute more then one operation together
     System.out.println("parallel"+reduced4);
     System.out.println("--------------------------");

     IntSummaryStatistics stats=IntStream.rangeClosed(1,10).summaryStatistics(); //to perform all the statistics operations together
        System.out.println(stats);
        System.out.println(stats.getMin());
        System.out.println(stats.getMax());
        System.out.println(stats.getCount());
        System.out.println(stats.getAverage());
        System.out.println(stats.getSum());

	}
}

/*
List <Integer>list=new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(9);
		list.add(10);


		System.out.println(list);System.out.println("-------------------------------");

		//3 phases of the Stream API
		// Stream s=list.stream(); //initialization
		// s.filter(x->x%2==0);//processing
		//List<Integer> ans= s.collect(Collectors.toList());//termination

       //in single line
		//filter out some elements
		List<Integer> l1=list.stream().filter(x->x%2==0).collect(Collectors.toList());
		System.out.println(l1);
		System.out.println("-------------------------------");
		 //or use predicate
		Predicate<Integer>p=x->(x%2)==0;
		List<Integer> l12=list.stream().filter(p.negate()).collect(Collectors.toList());
		System.out.println(l12);
		System.out.println("--------------------------------");

//--------------------------------------------------
		//Map => to perform operations on all the elements
		List l2=list.stream().map(x->x+x).collect(Collectors.toList());
		System.out.println(l2);
		System.out.println("-------------------------------");
//-------------------------------------------
        
		//to print numbers using random
		Random random=new Random();  //randomly generates all the streams
		random.ints().limit(10).sorted().forEach(System.out::println);
		System.out.println("-------------------------------");

		////to print numbers with in the ramge 
		IntStream is1=IntStream.rangeClosed(1,10);//inlcude both 1 and 10
		is1.forEach(System.out::println);
		System.out.println("-------------------------------");

		IntStream is2=IntStream.rangeClosed(1,10);//rnageClosed()->inlcude both 1 and 10
		is2.skip(4).limit(3).forEach(System.out::println);//skip() skips the starting 4 numbers 
		System.out.println("-------------------------------");
*/