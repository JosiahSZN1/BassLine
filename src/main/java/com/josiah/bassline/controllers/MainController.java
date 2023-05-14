package com.josiah.bassline.controllers;

import javax.naming.Binding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.josiah.bassline.models.Chorus;
import com.josiah.bassline.models.Song;
import com.josiah.bassline.models.Verse;
import com.josiah.bassline.services.ChorusService;
import com.josiah.bassline.services.SongService;
import com.josiah.bassline.services.VerseService;

@Controller
public class MainController {
	
	@Autowired
	private VerseService verseServ;
	
	@Autowired
	private ChorusService chorusServ;
	
	@Autowired
	private SongService songServ;
	
	@RequestMapping("/")
	public String index() {
		return "song.jsp";
	}
	
	@RequestMapping("/{songID}")
	public String rNewVerse(@PathVariable("songID") Long songID, Model model) {
		Song currentSong = songServ.findSong(songID);
		model.addAttribute("song", currentSong);
		return "song.jsp";
	}
	
	@RequestMapping("/{songID}/verse/new")
	public String rNewVerse(@ModelAttribute("newVerse") Verse verse, @PathVariable("songID") Long songID, Binding Result, Model model) {
		Song currentSong = songServ.findSong(songID);
		model.addAttribute("song", currentSong);
		return "verseForm.jsp";
	}
	
	@PostMapping("{songID}/verse/new")
	public String pNewVerse(@ModelAttribute("newVerse") Verse verse, BindingResult result, @PathVariable("songID") Long songID) {
		Verse thisVerse = verseServ.createOrUpdateVerse(verse);
		songServ.addVerses(songID, thisVerse.getId());
		return "redirect:/";
	}
	
	@RequestMapping("{songID}/chorus/new")
	public String rNewChorus(@ModelAttribute("newChorus") Chorus chorus, @PathVariable("songID") Long songID, Model model) {
		Song currentSong = songServ.findSong(songID);
		songServ.createOrUpdateSong(currentSong);
		return "chorusForm.jsp";
	}
	
	@PostMapping("{songID}/chorus/new")
	public String pNewChorus(@ModelAttribute("newChorus") Chorus chorus, @PathVariable ("songID") Long songID) {
		chorusServ.createOrUpdateChorus(chorus);
		return "redirect:/";
	}
	
	@RequestMapping("/song/new")
	public String rNewSong(@ModelAttribute("newSong") Song song) {
		return "songForm.jsp";
	}
	
	@PostMapping("/song/new")
	public String pNewSong(@ModelAttribute("newSong") Song song) {
		songServ.createOrUpdateSong(song);
		return "redirect:/";
	}

}
