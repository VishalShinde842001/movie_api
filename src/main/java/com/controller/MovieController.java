package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.service.MovieService;
import com.entity.*;

@RestController
@CrossOrigin
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	
	@GetMapping("/getMovie/id/{id}")
	public ResponseEntity<Movie> getMovie(@PathVariable int id) {
		Movie m=this.movieService.getMovie(id);
		if(m==null) {
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(m,HttpStatus.ACCEPTED);
	}
	@GetMapping("/getMovie/title/{title}")
	public ResponseEntity<Movie> getMovie(@PathVariable String title) {
		Movie m=this.movieService.getMovie(title);
		if(m==null) {
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(m,HttpStatus.ACCEPTED);
	}
	@GetMapping("/getMovie/all")
	public ResponseEntity<List<Movie>> getMovie() {
		List<Movie> m=this.movieService.getMovie();
		if(m==null) {
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(m,HttpStatus.ACCEPTED);
	}
	@PostMapping("/addMovie")
	public ResponseEntity<String> addMovie(@RequestBody Movie movie){
		boolean b=this.movieService.addMovie(movie);
		
		if(!b) {
		  return new ResponseEntity<String>("Movie Not Added Due to some Error",HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>("Movie Added Successfully",HttpStatus.ACCEPTED);
		}
	

}
