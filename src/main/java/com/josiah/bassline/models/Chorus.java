package com.josiah.bassline.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name="choruses")
public class Chorus {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;
	
	private String lineA;
	private String lineB;
	private String lineC;
	private String lineD;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="song_id")
    private Song song;
	
	public Chorus() {}
	
	
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



	public String getLineA() {
		return lineA;
	}



	public void setLineA(String lineA) {
		this.lineA = lineA;
	}



	public String getLineB() {
		return lineB;
	}



	public void setLineB(String lineB) {
		this.lineB = lineB;
	}



	public String getLineC() {
		return lineC;
	}



	public void setLineC(String lineC) {
		this.lineC = lineC;
	}



	public String getLineD() {
		return lineD;
	}



	public void setLineD(String lineD) {
		this.lineD = lineD;
	}



	public Song getSong() {
		return song;
	}



	public void setSong(Song song) {
		this.song = song;
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
