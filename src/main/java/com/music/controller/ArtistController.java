package com.music.controller;

import com.music.dto.ArtistDTO;
import com.music.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/artist")
public class ArtistController {

    private final ArtistService artistService;

    @Autowired
    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @GetMapping("/{name}/bounce")
    public ArtistDTO bounce(@PathVariable String name) {
        return artistService.bounce(name);
    }

    @GetMapping("/{name}/scrap")
    public ArtistDTO scrap(@PathVariable String name) {
        return artistService.scrap(name);
    }

    @GetMapping("/{name}/get")
    public ArtistDTO get(@PathVariable String name) {
        return artistService.get(name);
    }

    @PostMapping ("/create")
    public ArtistDTO create(@RequestBody ArtistDTO artistDto) {
        return artistService.create(artistDto);
    }
}
