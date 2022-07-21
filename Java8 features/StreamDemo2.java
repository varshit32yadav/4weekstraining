import java.util.*;
import java.util.stream.*;



/*------------------------------------ partitioningBy ,groupingBy ,mapping, summintInt --------------------------------------------- */
class Employee{
	String name;
	int age;
	int salary;		
	String designation;
	Employee(String name,int age,int salary,String designation){

		this.name=name;
		this.age=age;
		this.salary=salary;
		this.designation=designation;
	}

	public String toString(){
	    return   "name= " + name + ", age= " + age + '\'' +", salary= " + salary + ", designation ="+designation +"\n" ;
	}
}


public class StreamDemo2{
	public static void main(String[] args) {
		List<Employee> list=new ArrayList<>();
		list.add(new Employee("ram",23,23444,"programmer"));
		list.add(new Employee("kalu",24,25666,"tester"));
		list.add(new Employee("farok",25,34444,"developer"));
		list.add(new Employee("tidy",26,45444,"manager"));
		list.add(new Employee("noob",34,56444,"tester"));
		list.add(new Employee("relt",37,67444,"manager"));
		list.add(new Employee("lofi",38,78444,"developer"));
		list.add(new Employee("demal",39,89444,"programmer"));

		List<Employee>l1=list.stream().filter(emp->emp.designation.equals("manager")).collect(Collectors.toList());  //if 1 category use this
		System.out.println(l1);
		System.out.println("----------------------------------------------");

		Map<Boolean,List<Employee>> mp=list.stream().collect(Collectors.partitioningBy(e->e.age>30));
		System.out.println(mp);
		System.out.println("--------------------------------------------");

		Map<Boolean,List<Employee>> mp2=list.stream().collect(Collectors.partitioningBy(e->e.designation.equals("programmer")));  //if 2 categories use this
		mp2.entrySet().forEach(System.out::println);
		System.out.println("------------------------------------------------------------------------");

		Map<String,List<Employee>> mp3=list.stream().collect(Collectors.groupingBy(e->e.designation ));//if more then 2 categories
		mp3.entrySet().forEach(System.out::println);
		System.out.println("------------------------------------------------------------");

		Map<String,Long> mp4=list.stream().collect(Collectors.groupingBy(e->e.designation , Collectors.counting()));  
		mp4.entrySet().forEach(System.out::println);
		System.out.println("-----------------------------------------------------------");

		Map<String,List<String>> mp5=list.stream().collect(Collectors.groupingBy(e->e.designation , Collectors.mapping(e->e.name.toUpperCase(),Collectors.toList() )));  
		mp5.entrySet().forEach(System.out::println);
		System.out.println("-----------------------------------------------------------");

		Map<String,Integer> mp6=list.stream().collect(Collectors.groupingBy(e->e.designation , Collectors.summingInt(e->e.salary)));  
		mp6.entrySet().forEach(System.out::println);
		System.out.println("-----------------------------------------------------------");
	}
}

/*--------------------------------FlatMap()------------------------------------------------------------------

List<Integer>l1=Arrays.asList(1,2,3);
		List<Integer>l2=Arrays.asList(4,5,6);
		List<Integer>l3=Arrays.asList(7,8,9);
		

		List<List<Integer>>list=Arrays.asList(l1,l2,l3);
		System.out.println(list);
		System.out.println("-----------------------------");
		List<Integer>result=list.stream().flatMap(lt->lt.stream() ).map(x->x+x).collect(Collectors.toList());
		System.out.println(result);

		//flatMap() is used to flatten List of lists into a single list[basically to flatten the Collection of Collections objects]
		//(eg [[1, 2, 3], [4, 5, 6], [7, 8, 9]] to ---> [2, 4, 6, 8, 10, 12, 14, 16, 18]) inorder to perform further operations in the elements in the list
*/

/*---------------------------------------------Map use with stream-------------------------------------------------------

		Map<Integer,String>map=new HashMap<>();
		map.put(1,"ram");
		map.put(2,"kalu");
		map.put(3,"shyam");
		map.put(4,"golu");
		map.put(5,"gorat");
		map.put(6,"forak");

         map.entrySet().stream().map(Map.Entry::getKey).forEach(System.out::println); //forEach can be used to write some logic but cant return anything
         map.entrySet().stream().map(Map.Entry::getValue).forEach(System.out::println);
         System.out.println("---------------------");
        map.entrySet().stream().filter((me)->me.getKey()>3).map(Map.Entry::getValue).forEach(System.out::println); //print all the keys > 3 . here (me) in filter is taken as an entrySet()

*/