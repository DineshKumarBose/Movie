package org.movie.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Movie")
public class Movie {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	long id;
	
	@Column(name = "poster")
	String poster;
	
	@Column(name = "Title")
	String Title;
	
	@Column(name = "type")
	String type;
	
	@Column(name = "year")
	int year;
	
	@Override
	public String toString() {
		return "Movie [id=" + id + ", poster=" + poster + ", Title=" + Title + ", type=" + type + ", year=" + year
				+ ", imdbid=" + imdbid + "]";
	}

	@Column(name = "imdbid")
	String imdbid;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getImdbid() {
		return imdbid;
	}

	public void setImdbid(String imdbid) {
		this.imdbid = imdbid;
	}

}
