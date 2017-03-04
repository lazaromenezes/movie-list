package br.com.lazarodm.movielist.api.service.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.lazarodm.movielist.api.service.MovieServiceImpl;
import br.com.lazarodm.movielist.core.Movie;

public class MovieServiceImplTest {
	private static final Movie MY_MOVIE = new Movie();

	@Test
	public void addMovie(){
		List<Movie> movieStore = new ArrayList<Movie>();
		MovieServiceImpl service = new MovieServiceImpl(movieStore);

		service.addMovie(MY_MOVIE);

		Assert.assertEquals(MY_MOVIE, movieStore.get(0));
	}
	
	@Test
	public void list(){
		List<Movie> movieStore = new ArrayList<Movie>();
		MovieServiceImpl service = new MovieServiceImpl(movieStore);

		List<Movie> movies = service.list();

		Assert.assertEquals(movieStore, movies);		
	}
}
