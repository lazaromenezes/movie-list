package br.com.lazarodm.movielist.api.service;

import java.util.List;

public class MovieServiceImpl implements MovieService{

	private List<String> movieStore;

	public MovieServiceImpl(List<String> movieStore){
		this.movieStore = movieStore;
	}

	public void addMovie(String movie) {
		movieStore.add(movie);
	}
	
	public List<String> list(){
		return this.movieStore;
	}
}
