package br.com.lazarodm.movielist.api.resource.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.lazarodm.movielist.api.resource.MovieResource;
import br.com.lazarodm.movielist.api.service.MovieService;

public class MovieResourceTest {
	private static final String MOVIE_NAME = "Any Movie";
	
	private String savedMovie;
	private List<String> movieList;
	
	@Before
	public void setUp(){
		movieList = new ArrayList<String>();
	}
	
	@Test
	public void save(){
		MovieResource resource = new MovieResource(new MovieServiceStub());
		resource.save(MOVIE_NAME);
		
		Assert.assertEquals(MOVIE_NAME, savedMovie);
	}
	
	@Test
	public void list(){
		MovieResource resource = new MovieResource(new MovieServiceStub());
		
		Assert.assertEquals(movieList, resource.list());
	}
	
	private class MovieServiceStub implements MovieService{		
		public void addMovie(String movie) {
			MovieResourceTest.this.savedMovie = movie;
		}
		
		public List<String> list() {
			return movieList;
		}
	}
}
