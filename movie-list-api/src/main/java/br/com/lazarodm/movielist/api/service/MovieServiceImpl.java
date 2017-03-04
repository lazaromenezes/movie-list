package br.com.lazarodm.movielist.api.service;

import java.util.List;

import br.com.lazarodm.movielist.core.Movie;

public class MovieServiceImpl implements MovieService{

	private List<Movie> movieStore;

	public MovieServiceImpl(List<Movie> movieStore){
		this.movieStore = movieStore;
	}

	public void addMovie(Movie movie) {
		movieStore.add(movie);
	}
	
	public List<Movie> list(){
		return this.movieStore;
	}
}
