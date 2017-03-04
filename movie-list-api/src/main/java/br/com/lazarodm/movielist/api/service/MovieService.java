package br.com.lazarodm.movielist.api.service;

import java.util.List;

import br.com.lazarodm.movielist.core.Movie;

public interface MovieService {
	void addMovie(Movie movie);
	List<Movie> list();
}
