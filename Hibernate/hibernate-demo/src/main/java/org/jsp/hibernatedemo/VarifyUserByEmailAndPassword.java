package org.jsp.hibernatedemo;

import java.util.Scanner;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class VarifyUserByEmailAndPassword 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the email and padssword to verify trhe user");
		String email=sc.next();
		String password=sc.next();
		String hql="select u from User u where u.email=?1 and u.password=:ps";
		Session session=new Configuration().configure().buildSessionFactory().openSession();
		Query<User> query=session.createQuery(hql);
		query.setParameter(1, email);
		query.setParameter("ps", password);
		try {
			User user=query.getSingleResult();
			System.out.println("Varification Succesfull");
			System.out.println(user);
		}
		catch(NoResultException e) {
			System.err.println("Incvalid email and password");
		}
		
	}

}
