package br.com.lazarodm.movielist.api.resource.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.lazarodm.movielist.api.resource.MovieResource;
import br.com.lazarodm.movielist.api.service.MovieService;
import br.com.lazarodm.movielist.core.Movie;

public class MovieResourceTest {
	private static final Movie MOVIE = new Movie();
	
	private Movie savedMovie;
	private List<Movie> movieList;
	
	@Before
	public void setUp(){
		movieList = new ArrayList<Movie>();
	}
	
	@Test
	public void save(){
		MovieResource resource = new MovieResource(new MovieServiceStub());
		resource.save(MOVIE);
		
		Assert.assertEquals(MOVIE, savedMovie);
	}
	
	@Test
	public void list(){
		MovieResource resource = new MovieResource(new MovieServiceStub());
		
		Assert.assertEquals(movieList, resource.list());
	}
	
	private class MovieServiceStub implements MovieService{		
		public void addMovie(Movie movie) {
			MovieResourceTest.this.savedMovie = movie;
		}
		
		public List<Movie> list() {
			return movieList;
		}
	}
}
