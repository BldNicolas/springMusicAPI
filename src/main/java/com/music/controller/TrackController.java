package com.music.controller;

import com.music.dto.TrackDTO;
import com.music.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/track")
public class TrackController {

    private final TrackService trackService;

    @Autowired
    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    @GetMapping("/{id}/bounce")
    public TrackDTO bounce(@PathVariable Integer id) {
        return trackService.bounce(id);
    }

    @GetMapping("/{id}/scrap")
    public TrackDTO scrap(@PathVariable Integer id) {
        return trackService.scrap(id);
    }

    @GetMapping("/{id}/get")
    public TrackDTO get(@PathVariable Integer id) {
        return trackService.get(id);
    }

    @PostMapping("/create")
    public TrackDTO create(@RequestBody TrackDTO trackDTO) {
        return trackService.create(trackDTO);
    }

    @PostMapping("/{id}/update")
    public TrackDTO update(@PathVariable Integer id, @RequestBody TrackDTO trackDTO) {
        return trackService.update(id, trackDTO);
    }
}
