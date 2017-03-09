package br.com.lazarodm.movielist.store.cassandra;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

@Configuration
public class CassandraSessionConfiguration {
	@Bean
	public Session getSession(){
		final String contactPoint = "127.0.0.1";
		return Cluster.builder().addContactPoint(contactPoint).build().connect();
	}
}
