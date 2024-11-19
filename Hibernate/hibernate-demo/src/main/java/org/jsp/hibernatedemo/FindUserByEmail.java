package org.jsp.hibernatedemo;

import java.util.List;
import java.util.Scanner;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FindUserByEmail 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the email to find trhe user");
		String email=sc.next();
		String hql="select u from User u where email=?1";
		Session session=new Configuration().configure().buildSessionFactory().openSession();
		Query<User> query=session.createQuery(hql);
		query.setParameter(1, email);
		try
		{
			User user=query.getSingleResult();
			System.out.println("varification succesfull");
			System.out.println(user);
		}
		catch(NoResultException e)
		{
			System.out.println("Invalid email");
		}
		
		
		
	}

}
