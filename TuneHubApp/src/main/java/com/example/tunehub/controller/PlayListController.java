package com.example.tunehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.tunehub.entities.PlayList;
import com.example.tunehub.entities.Songs;
import com.example.tunehub.services.PlayListService;
import com.example.tunehub.services.SongsService;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class PlayListController {
	@Autowired
	
	PlayListService pserv;
	@Autowired
	SongsService songser;
	@GetMapping("/map-createplaylist")
	public String createPlaylist(Model model) {
		
		//fetching the songs using song service
		List<Songs> slist = songser.findAllSongs();
        //Adding the songs in the model
		model.addAttribute("slist", slist);
		
		
		//sending createplaylist
		
		return "createplaylist";
		
	}
	@PostMapping("/addplaylist")
	public String addPlaylist(@ModelAttribute PlayList playlist) {
		
		pserv.addPlaylist(playlist);
		
		List<Songs> songlist=playlist.getSong();
		for(Songs song: songlist) 
		{
			song.getPlaylist().add(playlist);
		songser.updateSong(song);	
		}
		
		return "playlist";
	}
	@GetMapping("/viewplaylist")
	public String viewPlaylist(Model model) {
		List<PlayList> plist=pserv.fetchPlaylist();
		model.addAttribute("plist",plist);
		//System.out.println(plist);
		return "viewplaylist";
		
	}
	

}
