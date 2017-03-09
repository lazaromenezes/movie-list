package br.com.lazarodm.movielist.store.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.lazarodm.movielist.core.Movie;
import br.com.lazarodm.movielist.store.service.MovieStoreService;

@RestController
@RequestMapping(value="/movie")
public class MovieStoreResource {
	private final MovieStoreService storeService;
	
	@Autowired
	public MovieStoreResource(MovieStoreService service){
		this.storeService = service;
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public void save(@RequestBody Movie movie){
		this.storeService.save(movie);
	}
	
	@RequestMapping(method=RequestMethod.GET, produces="application/json")
	public List<Movie> list(){
		return this.storeService.getAll();
	}
}
