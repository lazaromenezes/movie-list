package br.com.lazarodm.movielist.api;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
@ApplicationPath("/api")
public class MovieListApiResourceConfiguration extends ResourceConfig{
	public MovieListApiResourceConfiguration(){
		packages("br.com.lazarodm.movielist.api.resource");
	}
}
