package org.jsp.hibernatedemo;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchByGet 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the user id to display details");
		int id=sc.nextInt();
		Configuration cfg=new Configuration();
		cfg.configure();
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		User user=session.get(User .class,id);
		
		if(user!=null)
		{
			System.out.println("user found");
			System.out.println(user);
		}
		else {
			System.err.println("Invalid Id");
		}
	}

}
