package org.jsp.hibernatedemo;

import java.util.List;
import java.util.Scanner;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FindUserByName 
{
	public static void main(String[] args) 
	{
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the username to print details");
		String name=sc.next();
		String hql="select u from User u where u.name=?1";
		Session session=new Configuration().configure().buildSessionFactory().openSession();
		Query<User> query=session.createQuery(hql);
		query.setParameter(1, name);
		List<User> users=query.getResultList();
		
		if(users.isEmpty())
			System.err.println("No users with entered name");
		else
			for(User user:users)
			{
				System.out.println(user);
			}
		
		
}
}
