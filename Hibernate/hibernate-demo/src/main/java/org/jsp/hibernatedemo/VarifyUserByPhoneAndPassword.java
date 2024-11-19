package org.jsp.hibernatedemo;

import java.util.Scanner;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class VarifyUserByPhoneAndPassword 
{
	public static void main(String[] args) 
	{
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the phone number and password by verify user");
		long phone=sc.nextLong();
		String password=sc.next();
		String hql="select u from User u where u.phone=?1 and u.password=:ps";
		Session session=new Configuration().configure().buildSessionFactory().openSession();
		Query<User> query=session.createQuery(hql);
		query.setParameter(1, phone);
		query.setParameter("ps", password);
		try {
			User user=query.getSingleResult();
			System.out.println("Varification Succesfull");
			System.out.println(user);
		}
		catch(NoResultException e) {
			System.err.println("Incvalid phone number and password");
		}
		
	}

}
