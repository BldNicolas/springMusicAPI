package com.security.controller;

import com.security.entity.Artist;
import com.security.entity.DeezerArtist;
import com.security.service.ArtistService;
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
    public DeezerArtist artist(@PathVariable String name) {
        DeezerArtist deezerArtist = artistService.bounceArtist(name);
        return deezerArtist;
    }

    @GetMapping("/{name}/scrap")
    public Artist scrapArtist(@PathVariable String name) {
        Artist artist = artistService.scrapArtist(name);
        return artist;
    }

    @GetMapping("/{name}/get")
    public Artist getArtist(@PathVariable String name) {
        Artist artist = artistService.getArtist(name);
        return artist;
    }
}
