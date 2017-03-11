package br.com.lazarodm.movielist.store.inmemory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import br.com.lazarodm.movielist.core.Movie;
import br.com.lazarodm.movielist.store.MovieStore;

@Service
@Profile("inmemory")
public class InMemoryMovieStore implements MovieStore {

	private static List<Movie> movieList;
	
	public InMemoryMovieStore() {
		movieList = new ArrayList<>();
	}
	
	@Override
	public void save(Movie movie) {
		movieList.add(movie);
	}

	@Override
	public List<Movie> getAll() {
		return movieList;
	}
}
