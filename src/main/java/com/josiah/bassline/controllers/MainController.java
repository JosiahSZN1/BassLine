package com.josiah.bassline.controllers;

import javax.naming.Binding;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.josiah.bassline.models.Chorus;
import com.josiah.bassline.models.LoginUser;
import com.josiah.bassline.models.Song;
import com.josiah.bassline.models.User;
import com.josiah.bassline.models.Verse;
import com.josiah.bassline.services.ChorusService;
import com.josiah.bassline.services.SongService;
import com.josiah.bassline.services.UserService;
import com.josiah.bassline.services.VerseService;

@Controller
public class MainController {
	
	@Autowired
	private VerseService verseServ;
	
	@Autowired
	private ChorusService chorusServ;
	
	@Autowired
	private SongService songServ;
	
	@Autowired
	private UserService userServ;
	
	@GetMapping("/")
	public String rIndex(
			@ModelAttribute("createAccount") User newUser,
			@ModelAttribute("login") LoginUser loginUser 
			) {
		return "index.jsp";
	}
	
	@PostMapping("/register")
    public String pRegister(
    		@Valid @ModelAttribute("createAccount") User newUser, 
            BindingResult result, HttpSession session, Model model
            ) {
        userServ.register(newUser, result);     
        if(result.hasErrors()) {
        	model.addAttribute("newLogin", new LoginUser());
            return "index.jsp";
        }
        session.setAttribute("id", newUser.getId());
        return "redirect:/success";
    }
	
	@PostMapping("/login")
    public String pLogin(@Valid @ModelAttribute("login") LoginUser newLogin, 
            BindingResult result, Model model, HttpSession session) {
         User user = userServ.login(newLogin, result);
    
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "index.jsp";
        }
        session.setAttribute("id", user.getId());
        return "redirect:/success";
    }
	
	@GetMapping("/success")
    public String rSuccess(Model model, HttpSession session) {
    	Long userId = (Long) session.getAttribute("id");
    	if(userId==null) {
    		return "redirect:/";
    	}
    	User user = userServ.findUser(userId);
    	model.addAttribute("user", user);
    	return "dashboard.jsp";
    }
	
	@GetMapping("/logout")
    public String logout(HttpSession session) {
   	 session.setAttribute("id", null);
   	 return "redirect:/";
    }
	
	
	@GetMapping("/song/new")
	public String rNewSong(@ModelAttribute("newSong") Song song) {
		return "songForm.jsp";
	}
	
	@PostMapping("/song/new")
	public String pNewSong(@Valid @ModelAttribute("newSong") Song song, BindingResult result, HttpSession session) {
		if(result.hasErrors()) {
			return "songForm.jsp";
		}
		Song thisSong = songServ.createOrUpdateSong(song);
		User thisUser = userServ.findUser((Long) session.getAttribute("id"));
		thisSong.getWriters().add(thisUser);
		return "redirect:/song/" + song.getId();
	}
	

	
	@RequestMapping("/song/{songID}")
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
	
	

}
