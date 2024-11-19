package org.jsp.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateUser2 
{
	public static void main(String[] args) 
	{
		Configuration cfg=new Configuration();
		cfg.configure();
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		User user=new User();//Transient State
		user.setId(1);
		user.setName("sks");
		user.setEmail("sks@gmail.com");
		user.setPassword("sks123");
		user.setPhone(900080);
		session.update(user);
//		session.saveOrUpdate(user);
		transaction.commit();
		
		
	}

}
