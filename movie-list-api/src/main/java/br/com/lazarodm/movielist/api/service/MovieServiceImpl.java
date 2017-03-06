package br.com.lazarodm.movielist.api.service;

import java.util.List;

import javax.inject.Inject;

import br.com.lazarodm.movielist.core.Movie;
import br.com.lazarodm.movielist.store.service.client.MovieStoreServiceClient;

public class MovieServiceImpl implements MovieService{

	private MovieStoreServiceClient movieClient;

	@Inject
	public MovieServiceImpl(MovieStoreServiceClient movieClient){
		this.movieClient = movieClient;
	}

	public void addMovie(Movie movie) {
		movieClient.save(movie);
	}
	
	public List<Movie> list(){
		return this.movieClient.getAll();
	}
}
