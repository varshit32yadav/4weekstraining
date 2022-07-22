//semaphores [concurrent programming for showing more then 1 thread acquiring the lock]

import java.util.concurrent.*;

public class ConcurrencyDemo{

	public static void main(String[] args) {
		
		Semaphore sem=new Semaphore(1);// means 2 threads are there to acquire lock at same time 

		new IncThread("Daniel",sem);
		new DecThread("John", sem);
		new IncThread("Robert",sem);
		//new IncThread("lata", sem);
		//new DecThread("apec",sem);
		// new DecThread("sutrs", sem);
		// new IncThread("kalu",sem);
		// new IncThread("vibh", sem);
		
	}
}
class Shared{
	static int count =0;
}
class IncThread extends Thread{

	String name;
	Semaphore sem;
	IncThread(String name,Semaphore sem){
		this.name=name;
		this.sem=sem;
		new Thread(this).start();
	}
	public void run(){
		try{
			System.out.println(name +" is waiting for the permission");
			sem.acquire(); //lock acquired by the thread
			System.out.println(name +"  got the permission");
			for (int i=0;i<=2 ;i++ ) {
				Shared.count++;
				System.out.println(name +" "+Shared.count);
				Thread.sleep(500);
			}
		}
		catch(Exception e){
				System.out.println(e);
		}
		System.out.println(name +" is releasing the permission");
		sem.release(); //lock released by the thread
		System.out.println(name +" released the permission");
		
	}
}

class DecThread extends Thread{
	String name;
	Semaphore sem;
	DecThread(String name,Semaphore sem){
		this.name=name;
		this.sem=sem;
		new Thread(this).start();
	}
	public void run(){
		try{
			System.out.println(name +" is waiting for the permission");
			sem.acquire();
			System.out.println(name +"  got the permission");
			for (int i=0;i<=5 ;i++ ) {
				Shared.count--;
				System.out.println(name +" "+Shared.count);
				Thread.sleep(500);
			}
		}
		catch(Exception e){
				System.out.println(e);
		}
		System.out.println(name +" is releasing the permission");
		sem.release();
		System.out.println(name +" released the permission");
		
	}
}























/*
mutex is synchronized keyword only

2 benefits of semaphore over synchronized
1)you can have synchronization across different classes
2)you can have more then one thread acquiring the lock  


class A extends Thread{

	public synchronized void run(){  //synchronized  only allow a sibgle object to access the function .but if you will create the multiple objects, then all will enter the fuctnion . So better way is create a dingle object and create multiple thread objects with that single object . So only ine key will be there and others(Thread objects dervode from that object) have to share the key 
		
		synchronized(this){ // synchronized block for limimiting the some part of the fucntion
		//synchronized(A.class) - [class level blcoking (if different objects of class are created then only one can acess at class level locking)]
		//synchronized(this)[object level locking (one object at a time )]
        //synchronized(Object.class) [only one object of any class can access the blcok]

		//but if you want to allow object from A or B class only and not otjers classes , then cocurrent programming is there [using semaphores (semaphore s=new semaphore(2);) i.e 2 threads can enter the lock at sae time]


			for(int i=1;i<=5;i++){
				System.out.println( Thread.currentThread().getName() +" "+i);
			}

			try{
				Thread.sleep(500);
			}
			catch(Exception e){
				System.out.println(e);
			}
		}
	}
} 

public class ConcurrencyDemo{

	public static void main(String[] args) {
		
		A a1=new A();
		//a1.run();//function will be invoked but the thread is created with .start() only
        //a1.start()://thread is created 
		
        // A a1=new A();  
        // A a2=new A();
        // A a3=new A();
        //if you create 3 object of same class then they can all use the public synchronized void run() simultaneoulsy beacuas all of them have their own keys to enter the mehtod

        Thread a11=new Thread(a1);
        Thread a12=new Thread(a1);
        Thread a13=new Thread(a1);
        //but if you create 3 Thread objects from the single object of the class then all of them will have only one key to access the method and hemce they will use public synchronized void run() one by one

		a11.start();// a thread is created
		a12.start();
		a13.start();

		a11.setName("A11");
		a12.setName("A12");


		System.out.println("Main Exit");  //executed by main thread
	}
}

*/