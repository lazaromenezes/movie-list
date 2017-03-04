package br.com.lazarodm.movielist.api.resource;

import br.com.lazarodm.movielist.api.service.MovieService;

public class MovieResource {
	private MovieService movieService;
	
	public MovieResource(MovieService movieService){
		this.movieService = movieService;
	}
	
	public void save(String movie){
		this.movieService.addMovie(movie);
	}
}
