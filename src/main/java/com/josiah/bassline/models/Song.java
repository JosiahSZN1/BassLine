package com.josiah.bassline.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name="songs")
public class Song {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;
	
	private String title;
	
	@OneToOne(mappedBy="song", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private Chorus chorus;

	@OneToMany(mappedBy="song", fetch = FetchType.LAZY)
	private List<Verse> verses;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
	        name = "writers_songs", 
	        joinColumns = @JoinColumn(name = "song_id"), 
	        inverseJoinColumns = @JoinColumn(name = "user_id")
	    )
	private List<User> writers;
	
	
	
	public Song() {}
	
	
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Date getCreatedAt() {
		return createdAt;
	}



	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}



	public Date getUpdatedAt() {
		return updatedAt;
	}



	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public Chorus getChorus() {
		return chorus;
	}



	public void setChorus(Chorus chorus) {
		this.chorus = chorus;
	}



	public List<Verse> getVerses() {
		return verses;
	}



	public void setVerses(List<Verse> verses) {
		this.verses = verses;
	}



	public List<User> getWriters() {
		return writers;
	}



	public void setWriters(List<User> writers) {
		this.writers = writers;
	}



	@PrePersist
	protected void onCreate(){
		this.createdAt = new Date();
	}
	@PreUpdate
	protected void onUpdate(){
		this.updatedAt = new Date();
	}
}
