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

    @GetMapping("/{id}/bounce")
    public ArtistDTO bounce(@PathVariable Integer id) {
        return artistService.bounce(id);
    }

    @GetMapping("/{id}/scrap")
    public ArtistDTO scrap(@PathVariable Integer id) {
        return artistService.scrap(id);
    }

    @GetMapping("/{id}/get")
    public ArtistDTO get(@PathVariable Integer id) {
        return artistService.get(id);
    }

    @PostMapping("/create")
    public ArtistDTO create(@RequestBody ArtistDTO artistDto) {
        return artistService.create(artistDto);
    }

    @PostMapping("/{id}/update")
    public ArtistDTO update(@PathVariable Integer id, @RequestBody ArtistDTO artistDto) {
        return artistService.update(id, artistDto);
    }

    @DeleteMapping("/{id}/delete")
    public void delete(@PathVariable Integer id) {
        artistService.delete(id);
    }
}
