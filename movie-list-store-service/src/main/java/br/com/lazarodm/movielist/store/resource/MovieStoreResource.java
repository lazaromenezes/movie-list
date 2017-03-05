package br.com.lazarodm.movielist.store.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.lazarodm.movielist.core.Movie;
import br.com.lazarodm.movielist.store.cassandra.CassandraMovieStore;
import br.com.lazarodm.movielist.store.service.MovieStoreService;
import br.com.lazarodm.movielist.store.service.MovieStoreServiceImpl;

@Path("/movie")
public class MovieStoreResource {
	private final MovieStoreService storeService;
	
	public MovieStoreResource(){
		this(new MovieStoreServiceImpl(new CassandraMovieStore()));
	}
	
	public MovieStoreResource(MovieStoreService service){
		this.storeService = service;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void save(Movie movie){
		this.storeService.save(movie);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Movie> list(){
		return this.storeService.getAll();
	}
}
