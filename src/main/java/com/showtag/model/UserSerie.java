package com.showtag.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_serie")
public class UserSerie extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private User user;
	private Serie serie;
	private String episode;
	private Date watchDate;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	@ManyToOne
	@JoinColumn(name="id_user")
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	@ManyToOne
	@JoinColumn(name="id_serie")
	public Serie getSerie() {
		return serie;
	}
	
	public void setSerie(Serie serie) {
		this.serie = serie;
	}
	
	@Column(name = "episode", nullable = false)
	public String getEpisode() {
		return episode;
	}
	
	public void setEpisode(String episode) {
		this.episode = episode;
	}
	
	@Column(name = "watch_date", nullable = false)
	public Date getWatchDate() {
		return watchDate;
	}
	
	public void setWatchDate(Date watchDate) {
		this.watchDate = watchDate;
	}

}
