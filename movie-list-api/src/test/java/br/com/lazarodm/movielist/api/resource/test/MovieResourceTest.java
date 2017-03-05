package br.com.lazarodm.movielist.api.resource.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.lazarodm.movielist.api.resource.MovieResource;
import br.com.lazarodm.movielist.api.service.MovieService;
import br.com.lazarodm.movielist.core.Movie;

import static org.mockito.Mockito.*;

public class MovieResourceTest {
	private MovieService movieService;
	private List<Movie> mockList;
	private MovieResource target;
	
	@Before
	public void setUp(){
		mockList = (List<Movie>) mock(List.class);
		movieService = mock(MovieService.class);
		
		when(movieService.list()).thenReturn(mockList);
		
		target = new MovieResource(movieService);
	}
	
	@Test
	public void save(){
		Movie movie = new Movie();
		
		target.save(movie);
		
		verify(movieService).addMovie(movie);
	}
	
	@Test
	public void list(){
		List<Movie> actualList = target.list();
		
		Assert.assertEquals(mockList, actualList);
	}
}
