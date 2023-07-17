package Personal_Pack;

import java.util.*;
import java.sql.*;
public class PersonalMain {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		Scanner scan=new Scanner(System.in);
		int n=0;
		do {
		System.out.println("\t1.Register\n\t2.Display\n\t3.Update\n\t4.Delete\n\t5.Exit");
		System.out.print("Enter your choose: ");	
		 n=scan.nextInt();
	  switch(n)
		{
		case 1:
			register();
			break;
		case 2:
			display();
			break;
		case 3:
			update();
			break;
		case 4:
			delete();
			break;
		default:
			System.out.println("Exit");
		}	
	  System.out.println();
		}while(n>0 && n<5);
		
		System.out.println("--------End-----------");
	}
	//DELETE
	@SuppressWarnings("resource")
	static void delete() throws Exception
	{
		int del;
		String url="jdbc:mysql://localhost:3306/personal_details";
		String user="root";
		String pwd="surya";
		Scanner scanf=new Scanner(System.in);
		System.out.print("Enter id to delete:");
		del=scanf.nextInt();
		String Query="delete from t1 where id="+del;
		Connection con=DriverManager.getConnection(url,user,pwd);
		Statement st=con.createStatement();
	    del=st.executeUpdate(Query);
		System.out.println(del+" sucessfully deleted");
		con.close();
	}
	//UPDATE
	@SuppressWarnings("resource")
	static void update()throws SQLException
	{
	
		Scanner scan = new Scanner(System.in);
			String url="jdbc:mysql://localhost:3306/personal_details";//personal_details
			String user="root";
			String pwd="surya";
			String query="";
			System.out.println("--------DISPLAY--------");
			display();
			System.out.print("Enter id Number to change: ");
			int id=scan.nextInt();
			System.out.println("which column do you want to change? ");
			System.out.println("\t1.name\n\t2.phone\n\t3.Email   ");
			System.out.print("Enter 1,2,3: ");
			int val=scan.nextInt();
			if(val==1)
			{
				System.out.print("Enter Name: ");
				String n=scan.next();
				query="update t1 set name='"+n +"' where id="+id+";";
			}
			else if(val==2)
			{
				System.out.print("Enter phone: ");
				int p=scan.nextInt();
				query="update t1 set phone="+p+"where id="+id+";";
			}
			else if(val==3)
			{
				System.out.print("Enter email: ");
				String e=scan.next();
				query="update t1 set email='"+e+"' where id="+id+";";
			}
			
			Connection con=DriverManager.getConnection(url,user,pwd);
			Statement st=con.createStatement();
		 if(query.length()!=1)
		 {
			int r=st.executeUpdate(query);//pst.executeUpdate();
			System.out.println("successfully updated: "+r);
		  }	
			else
				System.out.println("Please choose only 1.name, 2.phone, 3.email");
			
		System.out.println();
		con.close();
	}
	//DISPLAY
	static void display() throws SQLException
	{
		
		String url="jdbc:mysql://localhost:3306/personal_details";
		String name="root";
		String pwd="surya";
		String query="Select * from t1";
		Connection con=DriverManager.getConnection(url,name,pwd);
		Statement st=con.createStatement();
		ResultSet result=st.executeQuery(query);
		while(result.next())
		{
			System.out.println(result.getInt(1)+" "+result.getString(2)+" "+result.getInt(3)+" "+result.getString(4));
		}
		con.close();
		System.out.println();
	}
	//REGISTER
	@SuppressWarnings("resource")
	static void register() throws SQLException
	{
		
		Scanner scanf=new Scanner(System.in);
		System.out.print("Enter id: ");
		 int id=scanf.nextInt();
		 System.out.println();
		System.out.print("Enter name: ");
		 String User=scanf.next();
		 System.out.println();
		System.out.print("Enter Phone: ");
		 int phone=scanf.nextInt();
		 System.out.println();
		System.out.print("Enter Email: ");
		 String email=scanf.next();
		
		String url="jdbc:mysql://localhost:3306/personal_details";
		String name="root";
		String pwd="surya";
		
		String query="insert into t1 values(?,?,?,?);";
		Connection con=DriverManager.getConnection(url,name,pwd);
		PreparedStatement pst=con.prepareStatement(query);
		pst.setInt(1, id);
		pst.setString(2,User);
		pst.setInt(3, phone);
		pst.setString(4,email);
		int row =pst.executeUpdate();
		System.out.println(row+" New User Added");
		System.out.println();
	}

}
