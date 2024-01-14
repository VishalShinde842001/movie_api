package com.entity;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String title;

    @Column(nullable = false)
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate releaseDate;

    @Column(nullable = false)
    private String genre;

    @Column(nullable = false)
    private Double rating = 0.0;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public Movie(int id, String title, LocalDate releaseDate, String genre, Double rating) {
		super();
		this.id = id;
		this.title = title;
		this.releaseDate = releaseDate;
		this.genre = genre;
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", releaseDate=" + releaseDate + ", genre=" + genre
				+ ", rating=" + rating + "]";
	}

	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}
