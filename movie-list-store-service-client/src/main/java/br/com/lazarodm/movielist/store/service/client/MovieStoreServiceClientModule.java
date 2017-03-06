package br.com.lazarodm.movielist.store.service.client;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;

public class MovieStoreServiceClientModule extends AbstractModule{

	@Override
	protected void configure() {
	}
	
	@Provides
	public MovieStoreServiceClient movieClient(){
		final String path = "http://localhost:8090";
		
		return Feign.builder()
					.encoder(new JacksonEncoder())
					.decoder(new JacksonDecoder())
					.target(MovieStoreServiceClient.class, path);
	}
}
