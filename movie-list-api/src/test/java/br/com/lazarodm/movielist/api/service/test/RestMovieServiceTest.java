package br.com.lazarodm.movielist.api.service.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.lazarodm.movielist.api.service.RestMovieService;

public class RestMovieServiceTest {
	private static final String MY_MOVIE = "My Movie";

	@Test
	public void addMovieCanAddToMovieStore(){
		List<String> movieStore = new ArrayList<String>();
		RestMovieService service = new RestMovieService(movieStore);

		service.addMovie(MY_MOVIE);

		Assert.assertEquals(MY_MOVIE, movieStore.get(0));
	}
}
