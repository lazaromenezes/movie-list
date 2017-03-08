package br.com.lazarodm.movielist.api.resource;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.lazarodm.movielist.api.service.MovieService;
import br.com.lazarodm.movielist.core.Movie;

@RestController
@RequestMapping(value="/movie")
public class MovieResource {
	private MovieService movieService;
	
	@Inject
	public MovieResource(MovieService movieService){
		this.movieService = movieService;
	}
	
	@RequestMapping(method=RequestMethod.POST, produces="application/json", consumes="application/json")
	public Response save(Movie movie){
		this.movieService.addMovie(movie);
		return Response.ok().build();
	}
	
	@RequestMapping(method=RequestMethod.GET, produces="application/json")
	public List<Movie> list(){
		return this.movieService.list();
	}
}
