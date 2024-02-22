package com.example.tunehub.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tunehub.entities.PlayList;
import com.example.tunehub.entities.Songs;
import com.example.tunehub.repositories.SongsRepository;
@Service
public class SongsServiceImplementation implements SongsService {
 @Autowired
	SongsRepository srepo;
	@Override
	public String addSongs(Songs songs) {
		srepo.save(songs);
		return "song is added";
	}
	@Override
	public boolean songExists(String name) {
		Songs song=srepo.findByName(name);
		if(song==null) 
		{
			return false;
		}
		else 
		{
			return true;
		}
		
	}
	@Override
	public List<Songs> findAllSongs() {
		List<Songs> songslist= srepo.findAll();
		return songslist;
	}
	
	@Override
	public void updateSong(Songs song) {
		srepo.save(song);
		
	}
	
	
	

}
