package br.com.lazarodm.movielist.store.service.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;

@Configuration
public class MovieStoreServiceFeignClientConfiguration{

	@Bean
	public MovieStoreServiceClient getMovieStoreService() {
		final String path = "http://localhost:8090";
		
		return Feign.builder()
				.encoder(new JacksonEncoder())
				.decoder(new JacksonDecoder())
				.target(MovieStoreServiceClient.class, path);
	}
}
