package br.com.lazarodm.movielist.store.resource.test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.lazarodm.movielist.core.Movie;
import br.com.lazarodm.movielist.store.resource.MovieStoreResource;
import br.com.lazarodm.movielist.store.service.MovieStoreService;

public class MovieStoreResourceTest {
	private MovieStoreService service;
	private MovieStoreResource target;
	private List<Movie> mockList;

	@Before
	public void setup(){
		mockList = mock(List.class);
		
		service = mock(MovieStoreService.class);
		when(service.getAll()).thenReturn(mockList);
		
		target = new MovieStoreResource(service);
	}
	
	@Test
	public void save(){
		Movie movie = new Movie();
		
		target.save(movie);
		
		verify(service).save(movie);
	}
	
	@Test
	public void list(){
		List<Movie> actualList = target.list();
		
		Assert.assertEquals(mockList, actualList);
	}
}
