package br.com.lazarodm.movielist.store.cassandra;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
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
@Profile("cassandra")
public class CassandraMovieStore implements MovieStore {

	private final String KEYSPACE = "MovieListKeySpace";
	private final String TABLE = "Movie";
	private final String KEY_FIELD = "key";
	private final String TITLE_FIELD = "title";

	private Session session;
	
	@Autowired
	public CassandraMovieStore(Session session){
		this.session = session;
	}
	
	@Override
	public void save(Movie movie) {
		Insert insert = QueryBuilder.insertInto(KEYSPACE, TABLE)
									.value(KEY_FIELD, UUIDs.timeBased())
									.value(TITLE_FIELD, movie.getTitle());
		
		session.execute(insert);
	}

	@Override
	public List<Movie> getAll() {
		Select select = QueryBuilder.select().from(KEYSPACE, TABLE);
		
		ResultSet resultSet = session.execute(select);
		
		List<Movie> movies = new ArrayList<>();
		
		for(Row row: resultSet.all())
			movies.add(createMovieFromRow(row));
			
		return movies;
	}
	
	private Movie createMovieFromRow(Row row){
		Movie movie = new Movie();
		movie.setTitle(row.getString(TITLE_FIELD));
		return movie;
	}
}