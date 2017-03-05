package br.com.lazarodm.movielist.store;

import java.util.List;

import br.com.lazarodm.movielist.core.Movie;

public interface MovieStore {
	void save(Movie movie);
	List<Movie> getAll();
}
