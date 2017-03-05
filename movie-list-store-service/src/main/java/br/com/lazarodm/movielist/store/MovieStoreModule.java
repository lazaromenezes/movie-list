package br.com.lazarodm.movielist.store;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.google.inject.Provides;
import com.google.inject.servlet.ServletModule;

import br.com.lazarodm.movielist.store.cassandra.CassandraMovieStore;
import br.com.lazarodm.movielist.store.service.MovieStoreService;
import br.com.lazarodm.movielist.store.service.MovieStoreServiceImpl;

public class MovieStoreModule extends ServletModule{
	@Override
	protected void configureServlets() {
		bind(MovieStore.class).to(CassandraMovieStore.class);
		bind(MovieStoreService.class).to(MovieStoreServiceImpl.class);
	}
	
	@Provides
	public Session sessionProvider(){
		return Cluster.builder().addContactPoint("127.0.0.1").build().connect();
	}
}
