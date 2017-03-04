package br.com.lazarodm.movielist.core;

import java.io.Serializable;

public class Movie implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
