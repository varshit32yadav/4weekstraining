/*
exchange(V x)– When invoked this function causes the current thread to suspend its execution and 
wait for another thread to call its exchange method. When another thread calls its exchange method, the threads exchange their data and the execution resumes.
*/


//--------------------------Exchanger API------------------------

import java.util.concurrent.*;
import java.io.*;

public class ConcurrencyDemo2{

	public static void main(String[] args) {

		Exchanger<String>ex=new Exchanger<String>();

		new Sender(ex);
		new Receiver(ex);
	}
}

class Sender extends Thread{
    Exchanger<String> ex;

	Sender(Exchanger<String>ex){
		this.ex=ex;
		new Thread(this).start();
	}
	public void run(){
		try{

			String names[]={"Ram","Shyam","kalu","Goru"};
			for(String s:names){
				String str=ex.exchange(s);  //when we put data it is sender and second one act as  a receiver  and vice-versa
				System.out.println("From sender :"+str);//str holds the mesg send by the receiver
				Thread.sleep(1000);
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}

class Receiver extends Thread{
    Exchanger<String> ex;

	Receiver(Exchanger<String>ex){
		this.ex=ex;
		new Thread(this).start();
	}
	public void run(){
		try{
			while(true){
				String s=(String)ex.exchange("HI bro"); //("") means receiver is sending back empty messg to sender
				System.out.println("received : "+s); //message send by sender will never be displayed by itself  as it is taken care internally by the sender it will always send to other classes


		    }
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}