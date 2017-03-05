package br.com.lazarodm.movielist.store.resource.test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;

import br.com.lazarodm.movielist.core.Movie;
import br.com.lazarodm.movielist.store.resource.MovieStoreResource;
import br.com.lazarodm.movielist.store.service.MovieStoreService;

public class MovieStoreResourceTest {
	@Test
	public void save(){
		MovieStoreService service = mock(MovieStoreService.class);
		MovieStoreResource target = new MovieStoreResource(service);
		Movie movie = new Movie();
		
		target.save(movie);
		
		verify(service).save(movie);
	}
}
