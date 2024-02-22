package com.example.tunehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.tunehub.entities.Songs;
import com.example.tunehub.services.SongsService;

@Controller
public class SongsController {
	@Autowired
	SongsService songser;

	@PostMapping("/addsongs")
	public String addSongs(@ModelAttribute Songs songs) {

		boolean songstatus = songser.songExists(songs.getName());
		if (songstatus == false) {
			songser.addSongs(songs);
			return "songsuccess";
		} else {
			return "songfail";
		}
	}

	@GetMapping("/map-viewsongs")
	public String viewSongs(Model model) {

		List<Songs> slist = songser.findAllSongs();

		model.addAttribute("slist", slist);
		return "displaysongs";
	}
	@GetMapping("/viewsongs")
	public String viewsong(Model model) {
		boolean primestatus = false;
		List<Songs> slist = songser.findAllSongs();

		model.addAttribute("slist", slist);
		if (primestatus == true) {
			
			
			return "displaysongs";
		} else {
			return "makepayment";
		}
	}
}
