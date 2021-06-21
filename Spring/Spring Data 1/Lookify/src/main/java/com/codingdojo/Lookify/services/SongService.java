package com.codingdojo.Lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.Lookify.models.Song;
import com.codingdojo.Lookify.repositories.SongRepository;

@Service
public class SongService {
    private final SongRepository songRepository;
    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }
    
    public List<Song> allSongs() {
        return songRepository.findAll();
    }
    
    public Song createSong(Song song) {
        return songRepository.save(song);
    }
    
    public Song findSong(Long id) {
        Optional<Song> optionalSong = songRepository.findById(id);
        if(optionalSong.isPresent()) {
            return optionalSong.get();
        } else {
            return null;
        }
    }
    
    public List<Song> findByArtists(String artist){
    	return songRepository.findByArtistContaining(artist);
    	
    }
}
