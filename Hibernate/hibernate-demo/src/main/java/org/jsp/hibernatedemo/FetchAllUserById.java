package org.jsp.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchAllUserById 
{
	public static void main(String[] args) 
	{
		String hql="select u.id from User u";
		Session session=new Configuration().configure().buildSessionFactory().openSession();
		Query<Integer> query=session.createQuery(hql);
		for(int id :query.getResultList())
		{
			System.out.println(id);
		}
		
	}
	

}
