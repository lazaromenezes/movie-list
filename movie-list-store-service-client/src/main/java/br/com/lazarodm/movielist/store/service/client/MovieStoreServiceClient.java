package br.com.lazarodm.movielist.store.service.client;

import java.util.List;

import br.com.lazarodm.movielist.core.Movie;
import feign.Headers;
import feign.RequestLine;

public interface MovieStoreServiceClient {
	@RequestLine("POST /store/movie")
	@Headers("Content-Type: application/json")
	void save(Movie movie);
	
	@RequestLine("GET /store/movie")
	List<Movie> getAll();
}
