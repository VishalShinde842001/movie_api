package com.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.entity.Movie;

@Repository
public class MovieDao {
	@Autowired
	private SessionFactory factory;
	
	public boolean addMovie(Movie movie) {
		try {
			Session session=factory.openSession();
			Transaction tx=session.beginTransaction();
			session.save(movie);
			tx.commit();
			session.close();
			return true;
		}
		catch(Exception e) {
			
			return false;
		}
	}
	public Movie getMovie(int id) {
		try {
			Session session=factory.openSession();
			Criteria c=session.createCriteria(Movie.class);
			c.add(Restrictions.eq("id", id));
			Movie m= (Movie)c.uniqueResult();
			if(m==null) {
				return null;
			}
			return m;
		}
		catch(Exception e) {
			System.out.println("Movie with this id is not present in db");
			return null;
		}
	}
	public Movie getMovie(String title) {
		try {
			Session session=factory.openSession();
			Criteria c=session.createCriteria(Movie.class);
			c.add(Restrictions.eq("title", title));
			Movie m= (Movie)c.uniqueResult();
			if(m==null) {
				return null;
			}
			return m;
		}
		catch(Exception e) {
			System.out.println("Movie with this id is not present in db");
			return null;
		}
	}
	public List<Movie> getMovie(){
		try {
			Session session=factory.openSession();
			Criteria c=session.createCriteria(Movie.class);
			List<Movie> m=c.list();
			return m;
		}catch(Exception e) {
			return null;
		}
		
	}
	


}
