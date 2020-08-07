package br.com.lazarodm.movielist.core;

import java.io.Serializable;
import java.util.List;

public class Movie implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String title;
  private List<CastMember> cast;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

  public List<CastMember> getCast(){
    return cast;
  }

  public void setCast(List<CastMember> cast){
    this.cast = cast;
  }
}
