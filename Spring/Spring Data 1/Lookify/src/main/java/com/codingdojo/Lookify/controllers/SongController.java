package com.codingdojo.Lookify.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.Lookify.models.Song;
import com.codingdojo.Lookify.services.SongService;

@Controller
public class SongController {
	private final SongService songService;
	public SongController(SongService songService) {
		this.songService=songService;
	}
	
	@RequestMapping("/")
	public String root() {
		return "index.jsp";
	}
	
	@RequestMapping("/dashboard")
	public String dashboard(Model model) {
		List <Song> allSongs=songService.allSongs();
		model.addAttribute("songs",allSongs);
		return "dashboard.jsp";
	}
	
	@RequestMapping(value="/songs/new",method=RequestMethod.GET)
	public String newSong(@ModelAttribute("song") Song song) {
		return "new.jsp";
	}
	
	@RequestMapping(value="/songs/new",method=RequestMethod.POST)
	public String createSong(@Valid @ModelAttribute("song") Song song,BindingResult result) {
		if (result.hasErrors()) {
            return "new.jsp";
        } else {
        	songService.createSong(song);       	
            return "redirect:/dashboard";
        }
    }
	
	@RequestMapping("/songs/{id}")
	public String songInfo(Model model,@PathVariable(value="id") Long id) {
		Song mySong=songService.findSong(id);
		model.addAttribute("song",mySong);
		return "info.jsp";
	}
	
	@RequestMapping("/searchProcess")
	public String searchForArtist(@RequestParam(value="searchForArtist") String searchForArtist) {
		return "redirect:/search/"+searchForArtist;
	}
	
	@RequestMapping("/search/{searchword}")
	public String search(@PathVariable(value="searchword") String searchword,Model model) {
		List<Song> allByArtist=songService.findByArtists(searchword);
		model.addAttribute("songs",allByArtist);
		model.addAttribute("searchword",searchword);
		return "search.jsp";
	}
}
