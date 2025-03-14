package com.music.service;

import com.music.dto.ArtistDTO;
import com.music.dto.DeezerTrackDTO;
import com.music.dto.TrackDTO;
import com.music.entity.Artist;
import com.music.entity.Track;
import com.music.mapping.DeezerTrackMapping;
import com.music.mapping.TrackMapping;
import com.music.repository.ArtistRepository;
import com.music.repository.TrackRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestClient;

@Service
public class TrackService {
    private final TrackRepository trackRepository;
    private final TrackMapping trackMapping;
    private final RestClient restClient;
    private final DeezerTrackMapping deezerTrackMapping;
    private final ArtistService artistService;
    private final ArtistRepository artistRepository;

    @Value("${deezer.url}")
    private String deezerUrl;

    public TrackService(
            TrackRepository trackRepository,
            TrackMapping trackMapping,
            RestClient restClient,
            DeezerTrackMapping deezerTrackMapping,
            ArtistService artistService,
            ArtistRepository artistRepository
    ) {
        this.trackRepository = trackRepository;
        this.trackMapping = trackMapping;
        this.restClient = restClient;
        this.deezerTrackMapping = deezerTrackMapping;
        this.artistService = artistService;
        this.artistRepository = artistRepository;
    }

    public TrackDTO bounce(Integer id) {
        String url = deezerUrl + "/track/" + id;

        DeezerTrackDTO deezerTrackDTO = restClient.get()
                .uri(url)
                .retrieve()
                .body(DeezerTrackDTO.class);
        TrackDTO trackDTO = deezerTrackMapping.deezerTrackDTOToTrackDTO(deezerTrackDTO);
        return trackDTO;
    }

    public TrackDTO scrap(Integer id) {
        TrackDTO trackDTO = this.bounce(id);
        Track track = trackMapping.dtoToEntity(trackDTO);

        Artist artist = artistRepository.findByName(track.getArtist().getName()).orElse(null);

        if (artist == null) {
            ArtistDTO artistDTO = artistService.scrap(track.getArtist().getIdDeezer());
            artist = artistRepository.findByName(artistDTO.getName()).orElse(null);
        }
        track.setArtist(artist);
        Track savedTrack = trackRepository.save(track);

        return trackMapping.entityToDto(savedTrack);
    }

    public TrackDTO get(Integer id) {
        Track track = trackRepository.findById(id).orElse(null);
        return trackMapping.entityToDto(track);
    }
}
