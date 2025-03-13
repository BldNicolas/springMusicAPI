package com.music.service;

import com.music.dto.DeezerTrackDTO;
import com.music.dto.TrackDTO;
import com.music.mapping.DeezerTrackMapping;
import com.music.mapping.TrackMapping;
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

    @Value("${deezer.url}")
    private String deezerUrl;

    public TrackService(TrackRepository trackRepository, TrackMapping trackMapping, RestClient restClient, DeezerTrackMapping deezerTrackMapping) {
        this.trackRepository = trackRepository;
        this.trackMapping = trackMapping;
        this.restClient = restClient;
        this.deezerTrackMapping = deezerTrackMapping;
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
}
