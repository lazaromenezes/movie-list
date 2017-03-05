package br.com.lazarodm.movielist.store.service;

import java.util.List;

import br.com.lazarodm.movielist.core.Movie;

public interface MovieStoreService {
	void save(Movie movie);
	List<Movie> getAll();
}