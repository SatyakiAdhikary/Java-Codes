package org.jsp.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateUser 
{
	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure();
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		User user=session.get(User.class,1);//persistent state
		user.setName("Boss");
		user.setEmail("user@gmail.com");
		user.setPassword("user23");
		transaction.commit();
	}

}
