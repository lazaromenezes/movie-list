package br.com.lazarodm.movielist.api.resource.test;

import org.junit.Assert;
import org.junit.Test;

import br.com.lazarodm.movielist.api.resource.MovieResource;
import br.com.lazarodm.movielist.api.service.MovieService;

public class MovieResourceTest {
	private static final String MOVIE_NAME = "Any Movie";
	
	private String savedMovie;
	
	@Test
	public void save(){
		
		MovieResource resource = new MovieResource(new MovieService() {
			public void addMovie(String movie) {
				MovieResourceTest.this.savedMovie = movie;
			}
		});
		resource.save(MOVIE_NAME);
		
		Assert.assertEquals(MOVIE_NAME, savedMovie);
	}
}
