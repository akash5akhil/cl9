$$AdderRemote$$

import java.rmi.*;
import java.rmi.server.*;

public class AdderRemote extends UnicastRemoteObject implements Adder{

AdderRemote()throws RemoteException{
super();
}

public String concat(String x, String y){return "This is Concatenated String:"+x+y;}

}

$$MyServer$$

import java.rmi.*;
import java.rmi.registry.*;

public class MyServer{

public static void main(String args[]){
try{

Adder stub=new AdderRemote();
Naming.rebind("rmi://localhost:5000/shack",stub);

}
catch(Exception e){System.out.println(e);}
}
}

$$MyClient$$

import java.rmi.*;

public class MyClient{

public static void main(String args[]){
try{

String str1 = "MIT";
String str2 = "-COE";


Adder stub=(Adder)Naming.lookup("rmi://localhost:5000/shack");
System.out.println(stub.concat(str1,str2));

}catch(Exception e){System.out.println(e);}
}

}
$$Adder$$
import java.rmi.*;
public interface Adder extends Remote{

public String concat(String x,String y)throws RemoteException;
}

to run
javac *.java
rmic AdderRemote
rmiregistry 5000
  java MyServer
  java MyClient
