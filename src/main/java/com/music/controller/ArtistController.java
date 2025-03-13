package com.music.controller;

import com.music.dto.ArtistDTO;
import com.music.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/artist")
public class ArtistController {

    private final ArtistService artistService;

    @Autowired
    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @GetMapping("/{name}/bounce")
    public ArtistDTO artist(@PathVariable String name) {
        return artistService.bounceArtist(name);
    }

    @GetMapping("/{name}/get")
    public Artist getArtist(@PathVariable String name) {
        Artist artist = artistService.getArtist(name);
        return artist;
    }
}
