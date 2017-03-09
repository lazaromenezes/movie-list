package br.com.lazarodm.movielist.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import br.com.lazarodm.movielist.store.service.client.MovieStoreServiceFeignClientConfiguration;

@SpringBootApplication
@Import(MovieStoreServiceFeignClientConfiguration.class)
public class MovieListApiApplication {
	public static void main(String... args){
		SpringApplication.run(MovieListApiApplication.class, args);
	}
}
