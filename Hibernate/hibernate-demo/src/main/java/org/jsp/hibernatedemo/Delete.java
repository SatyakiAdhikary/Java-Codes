package org.jsp.hibernatedemo;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Delete 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the ID to delete user");
		int id=sc.nextInt();
		Configuration cfg=new Configuration();
		cfg.configure();
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		User user=session.get(User.class, id);
		Transaction transaction=session.beginTransaction();
		if(user!=null) {
			session.delete(user);
			transaction.commit();
		}
		else
		{
		 System.err.println("cannot delete user as id is invalid");
		 
		}
		
	}

}
