package br.com.lazarodm.movielist.store.service;

import java.util.List;

import javax.inject.Inject;

import br.com.lazarodm.movielist.core.Movie;
import br.com.lazarodm.movielist.store.MovieStore;

public class MovieStoreServiceImpl implements MovieStoreService {
	private final MovieStore store;
	
	@Inject
	public MovieStoreServiceImpl(MovieStore store){
		this.store = store;
	}
	
	public void save(Movie movie){
		this.store.save(movie);
	}

	@Override
	public List<Movie> getAll() {
		return this.store.getAll();
	}
}
