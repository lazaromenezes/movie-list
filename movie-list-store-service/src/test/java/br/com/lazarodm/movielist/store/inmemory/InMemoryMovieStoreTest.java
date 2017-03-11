package br.com.lazarodm.movielist.store.inmemory;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.lazarodm.movielist.core.Movie;

public class InMemoryMovieStoreTest {
	@Test
	public void save(){
		InMemoryMovieStore target = new InMemoryMovieStore();
		
		Movie movie = new Movie();
		
		target.save(movie);
		
		List<Movie> savedMovieList = target.getAll();
		
		Assert.assertEquals(movie, savedMovieList.get(0));
	}
	
	@Test
	public void getAll(){
		InMemoryMovieStore target = new InMemoryMovieStore();
		
		Movie movie = new Movie();
		Movie otherMovie = new Movie();
		
		target.save(movie);
		target.save(otherMovie);
		
		List<Movie> savedMovieList = target.getAll();
		
		Assert.assertEquals(2, savedMovieList.size());
		Assert.assertEquals(movie, savedMovieList.get(0));
		Assert.assertEquals(otherMovie, savedMovieList.get(1));
	}
	
	@Test
	public void moviesAreSharedBetweenStoreInstances(){
		InMemoryMovieStore target = new InMemoryMovieStore();
		InMemoryMovieStore otherStore = new InMemoryMovieStore();
		
		Movie movie = new Movie();
		
		target.save(movie);
		
		List<Movie> savedMovieList = otherStore.getAll();
		
		Assert.assertEquals(1, savedMovieList.size());
		Assert.assertEquals(movie, savedMovieList.get(0));
	}
}
