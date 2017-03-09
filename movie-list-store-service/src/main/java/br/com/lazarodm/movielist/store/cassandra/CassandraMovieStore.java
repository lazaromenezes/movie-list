package br.com.lazarodm.movielist.store.cassandra;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.querybuilder.Insert;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;
import com.datastax.driver.core.utils.UUIDs;

import br.com.lazarodm.movielist.core.Movie;
import br.com.lazarodm.movielist.store.MovieStore;

@Service
public class CassandraMovieStore implements MovieStore {

	private Session session;
	
	@Autowired
	public CassandraMovieStore(Session session){
		this.session = session;
	}
	
	@Override
	public void save(Movie movie) {
		Insert insert = QueryBuilder.insertInto("MovieListKeySpace", "Movie")
									.value("key", UUIDs.timeBased())
									.value("title", movie.getTitle());
		
		session.execute(insert);
	}

	@Override
	public List<Movie> getAll() {
		Select select = QueryBuilder.select().from("MovieListKeySpace", "Movie");
		
		ResultSet resultSet = session.execute(select);
		
		List<Movie> movies = new ArrayList<Movie>();
		
		for(Row row: resultSet.all())
			movies.add(createMovieFromRow(row));
			
		return movies;
	}
	
	private Movie createMovieFromRow(Row row){
		Movie movie = new Movie();
		movie.setTitle(row.getString("title"));
		return movie;
	}

}
