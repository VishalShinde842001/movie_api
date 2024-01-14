package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.MovieDao;
import com.entity.*;
import java.util.List;
@Service
public class MovieService {

	@Autowired
	private MovieDao movieDao;
	public boolean addMovie(Movie movie) {
		try {
			if(movie.getRating()>5&&movie.getRating()<0) {
				System.out.println("Rating is Wrong way");
				return false;
			}
			return this.movieDao.addMovie(movie);
		}
		
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	public Movie getMovie(int id) {
		return this.movieDao.getMovie(id);
	}
	public Movie getMovie(String title) {
		return this.movieDao.getMovie(title);
	}
	public List<Movie> getMovie(){
		return this.movieDao.getMovie();
	}
}
