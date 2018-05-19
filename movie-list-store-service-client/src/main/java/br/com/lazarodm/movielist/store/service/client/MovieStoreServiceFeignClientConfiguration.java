package br.com.lazarodm.movielist.store.service.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;

@Configuration
public class MovieStoreServiceFeignClientConfiguration{

	@Value("${movieList.storeServiceUrl}")
	private String storeServiceUrl;

	@Bean
	public MovieStoreServiceClient getMovieStoreService() {
		return Feign.builder()
				.encoder(new JacksonEncoder())
				.decoder(new JacksonDecoder())
				.target(MovieStoreServiceClient.class, storeServiceUrl);
	}
}
