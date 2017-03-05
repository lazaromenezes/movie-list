package br.com.lazarodm.movielist.store.service.test;

import org.junit.Test;

import br.com.lazarodm.movielist.core.Movie;
import br.com.lazarodm.movielist.store.MovieStore;
import br.com.lazarodm.movielist.store.service.MovieStoreService;

import static org.mockito.Mockito.*;

public class MovieStoreServiceTest {
	@Test
	public void save(){
		MovieStore store = mock(MovieStore.class);
		MovieStoreService target = new MovieStoreService(store);
		
		Movie movie = new Movie();
		
		target.save(movie);
		
		verify(store).save(movie);
	}
}
