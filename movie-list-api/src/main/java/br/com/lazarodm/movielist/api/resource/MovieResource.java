package br.com.lazarodm.movielist.api.resource;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.lazarodm.movielist.api.service.MovieService;
import br.com.lazarodm.movielist.core.Movie;

@Component
@Path("/movie")
public class MovieResource {
	private MovieService movieService;
	
	@Inject
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
