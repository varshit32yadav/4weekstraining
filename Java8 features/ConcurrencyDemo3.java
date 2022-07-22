
//--------------------------CyclicBarrier API------------------------

import java.util.concurrent.*;

public class ConcurrencyDemo3{

	public static void main(String[] args) throws Exception{
		CyclicBarrier cb=new CyclicBarrier(5,new Action());//you want barrier for 3 threads
		
		System.out.println("Starting");
		for(int i=1;i<=10;i++){
			new MyThread("Thread "+i,cb);
			Thread.sleep(1000);
		}
	}
}

class MyThread extends Thread{
	String name;
	CyclicBarrier cb;

	MyThread(String name,CyclicBarrier cb){
		this.name=name;
		this.cb=cb;
		new Thread(this).start();
	}
	public void run(){

		try{
			System.out.println(name+" has arrived");
			cb.await();  //only allows further below satements to execute till 3(mentioned) threads have arrived 
			System.out.println(name+" started execution");
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}

class Action extends Thread{  //want to start a new thread after 3 threads have arrived at a particulaar point then CyclicBarrier cb=new CyclicBarrier(3,new Action())
	static int i=0;
	Action(){
		new Thread(this).start();
	}

	public void run(){
		System.out.println("execution of batch "+(i++)+"started");
	}
}










//      new MyThread("Ramesh");
// 		new MyThread("Suresh");
// 		new MyThread("Dinesh");
// 		new MyThread("Manoj");
// 		new MyThread("Dheeraj");