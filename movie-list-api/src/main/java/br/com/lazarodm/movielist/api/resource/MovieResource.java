package br.com.lazarodm.movielist.api.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.lazarodm.movielist.api.service.MovieService;
import br.com.lazarodm.movielist.core.Movie;

@RestController
@CrossOrigin
@RequestMapping(value="/movie")
public class MovieResource {
	private MovieService movieService;
	
	@Autowired
	public MovieResource(MovieService movieService){
		this.movieService = movieService;
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public void save(@RequestBody Movie movie){
		this.movieService.addMovie(movie);
	}
	
	@RequestMapping(method=RequestMethod.GET, produces="application/json")
	public List<Movie> list(){
		return this.movieService.list();
	}
}
