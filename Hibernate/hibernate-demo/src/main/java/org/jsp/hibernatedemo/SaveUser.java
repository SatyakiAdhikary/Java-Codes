package org.jsp.hibernatedemo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
 
public class SaveUser 
{
	public static void main(String[] args) 
	{
		User u=new User();
		u.setName("bosko");
		u.setEmail("bosk4455gmail.com");
		u.setPhone(80987616);
		u.setPassword("bosko200g");
		Configuration cfg=new Configuration();
//		Configuration cfg=new Configuration().configure();//Method chaining
		cfg.configure();
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		int id= (Integer) session.save(u);//Down casting,open boxing
		Transaction t=session.beginTransaction();
		t.commit();
		
		
	}

}
