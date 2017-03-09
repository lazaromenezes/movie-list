package br.com.lazarodm.movielist.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lazarodm.movielist.core.Movie;
import br.com.lazarodm.movielist.store.service.client.MovieStoreServiceClient;

@Service
public class MovieServiceImpl implements MovieService{

	private MovieStoreServiceClient movieClient;

	@Autowired
	public MovieServiceImpl(MovieStoreServiceClient movieClient){
		this.movieClient = movieClient;
	}

	@Override
	public void addMovie(Movie movie) {
		movieClient.save(movie);
	}
	
	@Override
	public List<Movie> list(){
		return this.movieClient.getAll();
	}
}
