package org.jsp.hibernatedemo;

import java.util.Scanner;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FinduserbyId 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the id to find user");
		int id=sc.nextInt();
		String hql="select u from User u where id=?1";
		Configuration cfg=new Configuration();
		cfg.configure();
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		Query<User> query=session.createQuery(hql);
		query.setParameter(1, id);
		try
		{
			User user=query.getSingleResult();
			System.out.println("varification succesfull");
			System.out.println(user);
		}
		catch(NoResultException e)
		{
			System.out.println("Invalid id");
		}
		
	}

}
