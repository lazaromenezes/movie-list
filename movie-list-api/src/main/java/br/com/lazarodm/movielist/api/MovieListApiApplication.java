package br.com.lazarodm.movielist.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import br.com.lazarodm.movielist.store.service.client.MovieStoreServiceFeignClientConfiguration;

@ComponentScan
@EnableAutoConfiguration
@Import(MovieStoreServiceFeignClientConfiguration.class)
public class MovieListApiApplication {
	public static void main(String... args){
		SpringApplication.run(MovieListApiApplication.class, args);
	}
}
