package br.com.lazarodm.movielist.api.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.lazarodm.movielist.api.service.MovieService;
import br.com.lazarodm.movielist.api.service.MovieServiceImpl;

@Path("/movie")
public class MovieResource {
	private MovieService movieService;
	private static final List<String> movieStore = new ArrayList<String>();
	
	public MovieResource(){
		this.movieService = new MovieServiceImpl(movieStore);
	}
	
	public MovieResource(MovieService movieService){
		this.movieService = movieService;
	}
	
	@POST
	public Response save(String movie){
		this.movieService.addMovie(movie);
		return Response.ok().build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<String> list(){
		return this.movieService.list();
	}
}
