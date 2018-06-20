import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class client1 {

	public static void main(String[] args) throws IOException {
		
		Socket s = new Socket("localhost",1444);
		//InputStream is = s.getInputStream();
        //InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        
		String temp;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter UserID and Password");
		System.out.println("User ID:");  
		   String user=sc.next(); 
		System.out.println("Password");  
		   String pass=sc.next();
		   //Scanner sc1 = new Scanner(s.getInputStream());
		   PrintStream p = new PrintStream(s.getOutputStream());
		   p.println(user);
		   p.println(pass);

		   temp = br.readLine();
		   String[] valueb = temp.split("@");
		   System.out.println("List of Members");
		   for(int i=0; i<valueb.length; i++)
		   {
			   System.out.println(valueb[i]);
		   }
		   	  System.out.println("1: Update an existing member");
	          System.out.println("2: Delete an existing member");
	          System.out.println("3: Add new member");
	          System.out.println("Choose an option by typing the respective number");
	          
	          int option = sc.nextInt();
	         // option = br.readLine();
	        //while(sc.nextInt() != 0)
	        	  
	          //{
	       bw.write(option);
	        bw.flush();
	          
		  s.close();
		   sc.close();
	}

}
