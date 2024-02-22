package com.example.tunehub.services;

import java.util.List;

import com.example.tunehub.entities.PlayList;
import com.example.tunehub.entities.Songs;

public interface SongsService {
	public String addSongs(Songs songs);
	
	public boolean songExists(String name);
	public List<Songs> findAllSongs();

	

	public void updateSong(Songs song);

}
