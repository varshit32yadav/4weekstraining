import java.util.*;
import java.util.stream.*;

class Employee{
	String name;
	int age;
	int salary;		
	String designation;
	String gender;
	String department;
	Employee(String name,int age,int salary,String designation,String gender,String department){

		this.name=name;
		this.age=age;
		this.salary=salary;
		this.designation=designation;
		this.gender=gender;
		this.department=department;
	}

	public String toString(){
	    return   "name= " + name + ", age= " + age + '\'' +", salary= " + salary + ", designation ="+designation + ", gender= "+gender +
	    ", department= "+department+ "\n" ;
	}
}


public class Assignment{
	public static void main(String[] args) {
		List<Employee> list=new ArrayList<>();
		list.add(new Employee("ram",23,23444,"programmer","male","AI"));
		list.add(new Employee("aj",24,25666,"tester","female","IT"));
		list.add(new Employee("Elina",55,34444,"developer","female","R&D"));
		list.add(new Employee("shawn",56,45444,"manager","male","AI"));
		list.add(new Employee("noob",34,56444,"tester","male","IT"));
		list.add(new Employee("disha",37,67444,"manager","female","R&D"));
		list.add(new Employee("lofi",48,78444,"developer","male","AI"));
		list.add(new Employee("diya",49,89444,"programmer","female","IT"));


        System.out.println("----------------------How many males and females working-----------------------");
        Map<String,Long>mp=list.stream().collect( Collectors.groupingBy(emp->emp.gender , Collectors.counting() ));
        mp.entrySet().forEach(System.out::println);

        System.out.println("----------------------Total expense department wise on monthly basis-----------------------");
        Map<String,Integer>mp2=list.stream().collect( Collectors.groupingBy(emp->emp.department ,Collectors.summingInt(e->e.salary)  ));
        mp2.entrySet().forEach(System.out::println);

        System.out.println("-----------------------top 5 senior most Employees-----------------------");
        list.stream().sorted( (e1,e2)->(e2.age-e1.age)).limit(5).forEach(e->System.out.println(e.name +"- "+ e.age));

        System.out.println("-----------------------Type of the Company-----------------------");
        Map<String,Long>mp3=list.stream().collect(Collectors.groupingBy(e->{
        	if(e.age<30) return "Young Age";
        	if(e.age>=30 && e.age<=40) return "Mid Age";
        	return "Senior Age" ;
        } , Collectors.counting()));
         mp3.entrySet().forEach(System.out::println);
         String ans = mp3.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();
         System.out.println("REsult : "+ans);


		
	}
}





























/*
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
*/