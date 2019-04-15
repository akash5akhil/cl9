Ring.java


import java.util.Scanner;
import java.util.Arrays;

public class Ring {

	static int process_id[] = new int[5];
	static int index[] = new int[5];
	static int status[] = new int[5];
	static int no_of_processes;
	
	public void election(int p)
	{
		int i,flag = 0;
		
		for(i=0;i<5;i++)
		{
			if(process_id[(p+i)%5] != process_id[4] && status[(p+i)%5] == 1 && process_id[(p+i)%5]!=0)
			{
				if(flag==1)
				{
					System.out.println(process_id[(p+i)%5]);
				}
				System.out.print("Msg sent by process "+process_id[(p+i)%5]+" to process ");
				index[i] = process_id[(p+i)%5];
				flag=1;
			}
			//System.out.println(process_id[(p+i)%5]);
		}
		System.out.println(process_id[p]);
		Arrays.sort(index);
		System.out.println("Msg sent by process "+process_id[p]+" to all process that process "+index[4]+" is coordinator");
	}
	
	public static void main(String[] args) {

		int i,ch=0,p;
		Scanner sc = new Scanner(System.in);
		Ring r = new Ring();
		
		System.out.println("Enter no. of processes");
		no_of_processes = sc.nextInt();
		
		System.out.println("Enter process IDs");
		for(i=0;i<no_of_processes;i++)
		{
			process_id[i] = sc.nextInt();
		}
		Arrays.sort(process_id);
		System.out.println("process "+process_id[4]+" is coordinator");
		for(i=0;i<5;i++)
			status[i]=1;
		status[4] = 0;
		do
		{
			System.out.println("Enter choice: \n1.Election\n2.Exit");
			ch = sc.nextInt();
			
			if(ch == 1)
			{
				for(i=0+(5-no_of_processes);i<4;i++)
				{
					System.out.println("["+i+"] "+process_id[i]);
				}
				System.out.println("process "+process_id[4]+" is coordinator");
				System.out.println("Enter process no. of initiator:");
				p = sc.nextInt();
				r.election(p);
			}
		}while(ch<2);
	}

}

