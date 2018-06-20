import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


class server {


	public static void main(String[] args) throws IOException {
		
		ServerSocket s = new ServerSocket(1818);
		Socket ss = s.accept();
		Scanner sc = new Scanner(ss.getInputStream());
		String user = sc.next();
		String pass = sc.next();
		InputStreamReader isr = new InputStreamReader(ss.getInputStream());
		BufferedReader br = new BufferedReader(new InputStreamReader(ss.getInputStream()));
		OutputStreamWriter p = new OutputStreamWriter(ss.getOutputStream());
		String admin="Member";
		//BufferedReader br=new BufferedReader(new InputStreamReader(ss.getInputStream()));
		BufferedWriter bw = new BufferedWriter(p);
		//String user = br.readLine();
		//String pass = br.readLine();
		
		try{
			Class.forName("com.mysql.jdbc.Driver");  
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Lokesh Java", "root", "");
			Statement stmt = conn.createStatement();
			Statement stmt1 = conn.createStatement();
			ResultSet validate=stmt.executeQuery("select * from lokeshtable where username='"+user+"' and password='"+pass+"'");
			
			 
			int count=0;
	           while(validate.next()){
	           count++;
	          }
	           ResultSet result = stmt.executeQuery("SELECT * FROM lokeshtable");
	           
	          if(count>0){
	        	  System.out.println();
	        	  //ResultSet result = stmt.executeQuery("SELECT * FROM lokeshtable");
	           //System.out.println("welcome "+user);
	        	 
	        	  
	           System.out.println("welcome "+user);
	           System.out.println();
	           System.out.println("List of Members");
	           System.out.println();
	           
				while(result.next()){
					String temp = (result.getString(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4)+"\t"+result.getString(5)+"\t"+result.getString(6)+"@");
					 bw.write(temp);
					 bw.flush();
				}

				
	           }
	          else{
	        	  String temp = ("Invalid UserID or Passowrd");
	        	  bw.write(temp);
	        	  bw.flush();
	          }
	         String option = sc.nextLine();
	        //  String option = br.readLine();
	          
	          
	              ResultSet adminval=stmt1.executeQuery("SELECT * FROM `lokeshtable` WHERE `Username`='"+user+"'");
	          while(adminval.next()){
	      
	          if(adminval.getString(8).equals("Admin") && count>0)
		          {
		        	//System.out.println("hello    "+adminval.getString(8)); 
	        	 admin = (adminval.getString(8));
		          }
	          }
	          
	          if(option == "1")
	          {
	        	  update(conn, stmt, admin);
	          }
	          if(option == "2")
	          {
	        	  delete();
	          }
	          if(option == "3")
	          {
	        	  add();
	          }
	          
	       /*   switch (option) {
	            case 1:{
					update(conn, stmt, admin);
	            }
	                     break;
	            case 2:  delete();
	                     break;
	            case 3:  add();
	                     break;
	                     }*/
	          
	        
		}catch (Exception e){
			e.getMessage();
		}
		 bw.flush();
		sc.close();
		s.close();
		ss.close();
	}
	private static void add() {
		// TODO Auto-generated method stub
		
	}

	private static void delete() {
		// TODO Auto-generated method stub
		
	}

	private static void update(Connection C, Statement S,String type) 
	{
		
		if(type.equals("Admin")){
			try {
				S.executeUpdate("UPDATE lokeshtable set Name='jksdbjksdf' WHERE Username='ba265'");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
