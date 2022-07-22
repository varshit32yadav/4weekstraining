import java.util.concurrent.*;
import java.io.*;

public class Chatbox{
	public static void main(String[] args) throws Exception {
		Exchanger<String>ex=new Exchanger<>();
		Exchanger<String>ex1=new Exchanger<>();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    System.out.println("Enter the name:");
	    Sender.sname=br.readLine();
	    System.out.println("Enter the name");
		Receiver.rname=br.readLine();
		new Sender(ex,ex1);
		new Receiver(ex,ex1);

	}
}

class Sender extends Thread{
	static String sname;
	Exchanger<String>ex;
	Exchanger<String>ex1;

	Sender(Exchanger<String>ex,Exchanger<String>ex1){
	
		this.ex=ex;
		this.ex1=ex1;
		new Thread(this).start();
	}

	public void run(){
		try{
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			//sem.acquire();
			while(true){
				String str=(String)ex.exchange(br.readLine());
				String str2=ex1.exchange("");
				System.out.println(Receiver.rname +": "+str2);
			}
			
		}
		catch(Exception e){
			System.out.println(e);
		}
		//sem.release();
	}
}
class Receiver extends Thread{

	static String rname;
	Exchanger<String>ex;
	Exchanger<String>ex1;
	Receiver(Exchanger<String>ex,Exchanger<String>ex1){
		this.ex1=ex1;
		this.ex=ex;
		
		new Thread(this).start();
	}

	public void run(){
		try{

			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			while(true){
				String str=(String)ex.exchange("");
				System.out.println(Sender.sname +": "+str);
				String str2=ex1.exchange(br.readLine());	
			}
			
		}
		catch(Exception e){
			System.out.println(e);
		}

	}
}
// class message{
// 	static String msg="";
// }
