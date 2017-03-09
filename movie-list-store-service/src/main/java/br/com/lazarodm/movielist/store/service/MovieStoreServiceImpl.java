package br.com.lazarodm.movielist.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lazarodm.movielist.core.Movie;
import br.com.lazarodm.movielist.store.MovieStore;

@Service
public class MovieStoreServiceImpl implements MovieStoreService {
	private final MovieStore store;

	@Autowired	
	public MovieStoreServiceImpl(MovieStore store){
		this.store = store;
	}
	
	@Override
	public void save(Movie movie){
		this.store.save(movie);
	}

	@Override
	public List<Movie> getAll() {
		return this.store.getAll();
	}
}
