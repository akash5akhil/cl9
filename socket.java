$$server$$

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class server {
	public static void main(String[] args) {
		int sum=0;
		int sub=0;
		int client = 1236;
		int additionServer = 1111;
		int subtractionServer = 2222;
		
		try {
			
			ServerSocket ss = new ServerSocket(client);
			Socket s = ss.accept();
			DataInputStream dis = new DataInputStream(s.getInputStream());
    		DataOutputStream dout2=new DataOutputStream(s.getOutputStream()); 

			int i = dis.readInt();
			int j = dis.readInt();
			int ch = dis.readInt();
//			int num = i + j;
//			System.out.println("Sum " + num);
			switch(ch){
			case 1:
				Socket s1=new Socket("localhost",additionServer);  
	    		DataOutputStream dout=new DataOutputStream(s1.getOutputStream()); 
				DataInputStream din = new DataInputStream(s1.getInputStream());

	    		dout.writeInt(i);
	    		dout.writeInt(j);
	    		sum = din.readInt();
	    		s1.close();
	    		dout2.writeInt(sum);	    		
	    		break;
			
			case 2:
				Socket s11=new Socket("localhost",subtractionServer);  
	    		DataOutputStream dout1=new DataOutputStream(s11.getOutputStream()); 
				DataInputStream din1 = new DataInputStream(s11.getInputStream());

	    		dout1.writeInt(i);
	    		dout1.writeInt(j);
	    		sub = din1.readInt();
	    		s11.close();
	    		dout2.writeInt(sub);	    		
	    		break;
			
			}
			ss.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

$$additionServer$$
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class additionServer {
	public static void main(String[] args) {
		
		try {
			
			ServerSocket ss = new ServerSocket(1111);
			Socket s = ss.accept();
			DataInputStream dis = new DataInputStream(s.getInputStream());
    		DataOutputStream dout=new DataOutputStream(s.getOutputStream()); 

			int i = dis.readInt();
			int j = dis.readInt();
			int num = i + j;
			
			dout.writeInt(num);
			
//			System.out.println("Sum " + num);
			ss.close();
			
			
			
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

$$subtractionServer$$

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class subtractionServer {
	public static void main(String[] args) {
		
		try {
			
			ServerSocket ss = new ServerSocket(2222);
			Socket s = ss.accept();
			DataInputStream dis = new DataInputStream(s.getInputStream());
    		DataOutputStream dout=new DataOutputStream(s.getOutputStream()); 

			int i = dis.readInt();
			int j = dis.readInt();
			int num = i - j;
			
			dout.writeInt(num);
			
//			System.out.println("Sum " + num);
			ss.close();		
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

$$client$$

import java.io.*;  
import java.net.*; 
import java.util.Scanner;
public class client 
{  
    public static void main(String[] args)
    {  
    	try
    	{      
    		Socket s=new Socket("localhost",1236);  
    		DataOutputStream dout=new DataOutputStream(s.getOutputStream()); 
			DataInputStream dis = new DataInputStream(s.getInputStream());

    		Scanner in = new Scanner(System.in); 
		    System.out.printf("Enter i Value:  ");
		    int i = in.nextInt();
		    System.out.printf("Enter j Value:  ");
		    int j = in.nextInt();
		    
		    dout.writeInt(i);
		    dout.writeInt(j);
		    
		    int ch;
			System.out.println("Enter 1 for addition\n");
		    System.out.println("Enter 2 for subtraction\n");
//		    System.out.println("Enter 3 for multiplication\n");
//		    System.out.println("Enter 4 for division\n");
		    ch = in.nextInt();
		    dout.writeInt(ch);
		    
		    int sum = dis.readInt(); 
		    
		    System.out.println("Ans: " + sum);
		    
/*		    dout.writeUTF(""+ sum);  
		    dout.flush();  
		    dout.close();  
*/		    s.close();  
    	}
    	catch(Exception e)
    	{
    		System.out.println(e);
    	}  
    }  
}  

to run
java *.java
java Server
java AdditionServer
java SubtractorServer
java Client











