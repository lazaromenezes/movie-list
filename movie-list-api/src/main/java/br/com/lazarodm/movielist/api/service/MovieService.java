package br.com.lazarodm.movielist.api.service;

import java.util.List;

public interface MovieService {
	void addMovie(String movie);
	List<String> list();
}
