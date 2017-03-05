package br.com.lazarodm.movielist.store.service.test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.lazarodm.movielist.core.Movie;
import br.com.lazarodm.movielist.store.MovieStore;
import br.com.lazarodm.movielist.store.service.MovieStoreServiceImpl;


public class MovieStoreServiceImplTest {
	private List<Movie> mockList;
	private MovieStore store;
	private MovieStoreServiceImpl target;

	@Before
	public void setup(){
		mockList = mock(List.class);
		
		store = mock(MovieStore.class);
		when(store.getAll()).thenReturn(mockList);
		
		target = new MovieStoreServiceImpl(store);
	}
	
	@Test
	public void save(){
		Movie movie = new Movie();
		
		target.save(movie);
		
		verify(store).save(movie);
	}
	
	@Test
	public void list(){
		List<Movie> actualList = target.getAll();
		
		Assert.assertEquals(mockList, actualList);
	}
}
