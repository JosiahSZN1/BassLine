package com.josiah.bassline.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.josiah.bassline.models.Song;
import com.josiah.bassline.models.Verse;
import com.josiah.bassline.repositories.SongsRepository;

@Service
public class SongService {

	@Autowired
	private SongsRepository songsRepo;
	
	@Autowired
	private VerseService verseServ;
	
	public Song createOrUpdateSong(Song s) {
		return songsRepo.save(s);
	}
	
	public List<Song> allSongs() {
		return songsRepo.findAll();
	}
	
	public Song findSong(Long id) {
		Optional<Song> optionalSong = songsRepo.findById(id);
		if(optionalSong.isPresent()) {
			return optionalSong.get();
		} else {
			return null;
		}
	}
	
	public Song addVerses(Long songID, Long verseID) {
		Song thisSong = this.findSong(songID);
		Verse thisVerse = verseServ.findVerse(verseID);
		thisSong.getVerses().add(thisVerse);
		return songsRepo.save(thisSong);
	}
	
	public void deleteSong(Long id) {
		songsRepo.deleteById(id);
	}
}
