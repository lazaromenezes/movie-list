package br.com.lazarodm.movielist.store.service;

import br.com.lazarodm.movielist.core.Movie;
import br.com.lazarodm.movielist.store.MovieStore;

public class MovieStoreService {
	private final MovieStore store;
	
	public MovieStoreService(MovieStore store){
		this.store = store;
	}
	
	public void save(Movie movie){
		this.store.save(movie);
	}
}
