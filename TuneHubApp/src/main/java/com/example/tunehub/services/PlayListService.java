package com.example.tunehub.services;

import java.util.List;

import com.example.tunehub.entities.PlayList;
import com.example.tunehub.entities.Songs;

public interface PlayListService   {
	public void addPlaylist(PlayList playlist);

	public List<PlayList> fetchPlaylist();
	

}
