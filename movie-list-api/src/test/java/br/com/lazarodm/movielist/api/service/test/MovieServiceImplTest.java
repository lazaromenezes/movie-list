package br.com.lazarodm.movielist.api.service.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.lazarodm.movielist.api.service.MovieServiceImpl;

public class MovieServiceImplTest {
	private static final String MY_MOVIE = "My Movie";

	@Test
	public void addMovieCanAddToMovieStore(){
		List<String> movieStore = new ArrayList<String>();
		MovieServiceImpl service = new MovieServiceImpl(movieStore);

		service.addMovie(MY_MOVIE);

		Assert.assertEquals(MY_MOVIE, movieStore.get(0));
	}
}
