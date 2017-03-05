CREATE KEYSPACE MovieListKeySpace WITH REPLICATION = {'class':'SimpleStrategy', 'replication_factor':1};

USE MovieListKeySpace;

CREATE TABLE Movie (
	key UUID PRIMARY KEY,
	title TEXT
);