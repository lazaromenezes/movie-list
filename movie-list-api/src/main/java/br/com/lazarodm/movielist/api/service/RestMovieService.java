package br.com.lazarodm.movielist.api.service;

import java.util.List;

public class RestMovieService implements MovieService{

	private List<String> movieStore;
	
	public void addMovie(String movie) {
		movieStore.add(movie);
	}

}
