package br.com.lazarodm.movielist.api.service.test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.lazarodm.movielist.api.service.MovieServiceImpl;
import br.com.lazarodm.movielist.core.Movie;

public class MovieServiceImplTest {
	private static final Movie MY_MOVIE = new Movie();
	private List<Movie> movieStore;
	private MovieServiceImpl target;

	@Before
	public void setup(){
		movieStore = mock(List.class);
		target = new MovieServiceImpl(movieStore);
	}
	
	@Test
	public void addMovie(){
		target.addMovie(MY_MOVIE);

		verify(movieStore).add(MY_MOVIE);
	}
	
	@Test
	public void list(){
		List<Movie> movies = target.list();

		Assert.assertEquals(movieStore, movies);		
	}
}
