package br.com.lazarodm.movielist.api.service.test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.lazarodm.movielist.api.service.MovieServiceImpl;
import br.com.lazarodm.movielist.core.Movie;
import br.com.lazarodm.movielist.store.service.client.MovieStoreServiceClient;

public class MovieServiceImplTest {
	private static final Movie MY_MOVIE = new Movie();
	private MovieStoreServiceClient movieStoreClient;
	private List<Movie> mockList;
	private MovieServiceImpl target;

	@Before
	public void setup(){
		mockList = mock(List.class);
		
		movieStoreClient = mock(MovieStoreServiceClient.class);
		when(movieStoreClient.getAll()).thenReturn(mockList);
		
		target = new MovieServiceImpl(movieStoreClient);
	}
	
	@Test
	public void addMovie(){
		target.addMovie(MY_MOVIE);

		verify(movieStoreClient).save(MY_MOVIE);
	}
	
	@Test
	public void list(){
		List<Movie> movies = target.list();

		Assert.assertEquals(mockList, movies);		
	}
}
