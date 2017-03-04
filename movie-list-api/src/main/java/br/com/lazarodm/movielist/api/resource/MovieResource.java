package br.com.lazarodm.movielist.api.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.lazarodm.movielist.api.service.MovieService;
import br.com.lazarodm.movielist.api.service.MovieServiceImpl;
import br.com.lazarodm.movielist.core.Movie;

@Path("/movie")
public class MovieResource {
	private MovieService movieService;
	private static final List<Movie> movieStore = new ArrayList<Movie>();
	
	public MovieResource(){
		this.movieService = new MovieServiceImpl(movieStore);
	}
	
	public MovieResource(MovieService movieService){
		this.movieService = movieService;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response save(Movie movie){
		this.movieService.addMovie(movie);
		return Response.ok().build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Movie> list(){
		return this.movieService.list();
	}
}
