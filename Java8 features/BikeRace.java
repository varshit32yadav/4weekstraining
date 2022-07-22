import java.util.concurrent.*;
import java.time.*;
import java.time.temporal.*;
public class BikeRace{

	public static void main(String[] args) {
        try{
		    CyclicBarrier cb=new CyclicBarrier(10);
			CyclicBarrier cb2=new CyclicBarrier(10);
		    for(int i =1; i<=10;i++)
            {
                new Bike("Biker "+i,cb,cb2);
                Thread.sleep(200);
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
		
	}
}

class Bike extends Thread{
	String name;
	CyclicBarrier cb;
	CyclicBarrier cb2;
	LocalTime st;
	LocalTime et;
	int ranking;

	Bike(String name,CyclicBarrier cb,CyclicBarrier cb2)
    {
		this.name=name;
		this.cb=cb;
		this.cb2=cb2;
		new Thread(this).start();
	}
	public void run(){

		try{
			System.out.println(name+" is ready ");
            cb.await();
			this.st= LocalTime.now();
			for(int i = 1; i<=10; i++)
            {
                Thread.sleep((long)((Math.random() * 1000)));
            }
			this.ranking = ++Rank.count;
			this.et= LocalTime.now();
			cb2.await();
			System.out.println(name+" rank: "+ranking+" start time: "+this.st+" end time: "+this.et+" time taken: ");
			
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}
class Rank
{
    static int count = 0;
}


// import java.util.concurrent.*;
// import java.io.*;
// import java.util.Random.*;

// public class ConcurrencyDemo3{

// 	public static void main(String[] args) throws Exception{
// 		CyclicBarrier cb=new CyclicBarrier(10,new Action());//you want barrier for 3 threads
		
// 		System.out.println("Starting the race");
// 		for(int i=1;i<=10;i++){
// 			new MyThread("Bike "+i,cb);
// 			Thread.sleep(1000);
// 		}

// 	}
// }
// class MyThread extends Thread{
// 	String name;
// 	CyclicBarrier cb;

// 	MyThread(String name,CyclicBarrier cb){
// 		this.name=name;
// 		this.cb=cb;
// 		new Thread(this).start();
// 	}
// 	public void run(){

// 		try{
// 			System.out.println(name+" is ready");
// 			cb.await();
// 			System.out.println("All bikeas are ready start the race ");
// 			synchronized(this){
// 				long st=System.currentTimeMillis() ;
// 				Random rand = new Random();
// 				float float_random=rand.nextFloat();
// 				Thread.sleep((int)float_random*2);
// 	            long et=System.currentTimeMillis() ;
// 				System.out.println("name "+name+"   start time"+st +"  end time "+et);
// 			}
// 		}
// 		catch(Exception e){
// 			System.out.println(e);
// 		}
// 	}
// }
