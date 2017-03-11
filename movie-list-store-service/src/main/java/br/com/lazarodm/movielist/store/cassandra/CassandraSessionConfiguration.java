package br.com.lazarodm.movielist.store.cassandra;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

@Configuration
@Profile("cassandra")
public class CassandraSessionConfiguration {
	@Value("${cassandra.contactPoint}")
	private String contactPoint;
	
	@Bean
	public Session getSession(){
		return Cluster.builder().addContactPoint(contactPoint).build().connect();
	}
}
