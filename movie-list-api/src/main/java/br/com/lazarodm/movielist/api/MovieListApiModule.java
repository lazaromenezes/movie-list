package br.com.lazarodm.movielist.api;

import com.google.inject.servlet.ServletModule;

import br.com.lazarodm.movielist.api.service.MovieService;
import br.com.lazarodm.movielist.api.service.MovieServiceImpl;

public class MovieListApiModule extends ServletModule{
	@Override
	protected void configureServlets() {
		bind(MovieService.class).to(MovieServiceImpl.class);
	}
}
