package org.jsp.hibernatedemo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import org.hibernate.query.Query;

public class FindAllUsers 
{
	public static void main(String[] args) 
	{
		Session session=new Configuration().configure().buildSessionFactory().openSession();
		Query<User> query=session.createQuery("Select u from User u");
		List<User>  users=query.getResultList();
		if(users.isEmpty()) {
			System.err.println("No users Present");
		}
		else {
			for(User user :users) {
				System.out.println(user);
			}
		}
		
	}

}
