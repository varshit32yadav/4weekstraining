// @FunctionalInterface //has only one abstract method of its own which is not the part if the object class
// interface I{
// 	abstract void abc();
// 	abstract int hashCode();
// }

/*
//to resolve diamond problem in Interface
interface I{
	default void abc(){
		System.out.println("Hi from I.abc()");
	}
}
interface J{
	default void abc(){
		System.out.println("Hi from J.abc()");
	}
}
class A implements I,J{
	public void abc(){ //to resolve diamond problem in Interface
		I.super.abc();
		J.super.abc();
		System.out.println("Hi from class A");
	}

}
public interface jav8defaultMethods{
	public static void main(String[] args) {
		A a=new A();
         a.abc();

	}
}
*/
//Method Reference
interface I{
	void abc(String s);
}
interface J{
	A getObject();
}
class A{
	A(){
		System.out.println("From A()");
	}
	public static int staticMethod(String name){
		System.out.println("Wlecome name = "+  name);
		return 10;
	}
}
public interface jav8defaultMethods{
	public static void main(String[] args) {
		J j1=A::new;
		A a1=j1.getObject();
		A a2=j1.getObject();
		System.out.println(a1);
		System.out.println(a2);

		I i1=A::staticMethod;
		i1.abc("RAM");
		i1.abc("SHYAM");
		i1.abc("DINESH");

	}
}