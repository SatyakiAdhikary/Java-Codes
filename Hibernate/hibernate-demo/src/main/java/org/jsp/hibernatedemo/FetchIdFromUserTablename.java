package org.jsp.hibernatedemo;

import java.util.List;
import java.util.Scanner;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchIdFromUserTablename 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the name and get id");
		String name=sc.next();
		String hql="select u.id from User u where u.name=?1";
		Session session=new Configuration().configure().buildSessionFactory().openSession();
		Query<Integer> query=session.createQuery(hql);
		query.setParameter(1, name);
		query.getResultList();
		for(Integer id:query.getResultList())
		{
			System.out.println(id);
		}
		}
	
}
