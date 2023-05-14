package com.josiah.bassline.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.josiah.bassline.models.Verse;
import com.josiah.bassline.repositories.VerseRepository;

@Service
public class VerseService {

	@Autowired
	private VerseRepository verseRepo;
	
	public Verse createOrUpdateVerse(Verse v) {
		return verseRepo.save(v);
	}
	
	public List<Verse> allVerses() {
		return verseRepo.findAll();
	}
	
	public Verse findVerse(Long id) {
		Optional<Verse> optionalVerse = verseRepo.findById(id);
		if(optionalVerse.isPresent()) {
			return optionalVerse.get();
		} else {
			return null;
		}
	}
	
	public void deleteVerse(Long id) {
		verseRepo.deleteById(id);
	}
	
}
