package com.security.service;

import com.security.entity.Artist;
import com.security.entity.DeezerArtist;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.beans.factory.annotation.Value;

@Service
public class ArtistService {

    private final RestClient restClient;
    private final String deezerUrl;

    public ArtistService(@Value("${deezer.url}") String deezerUrl) {
        this.deezerUrl = deezerUrl;
        this.restClient = RestClient.create();
    }

    public DeezerArtist bounceArtist(String name) {
        String url = deezerUrl + "/artist/" + name;
        DeezerArtist deezerArtist = restClient.get()
                .uri(url)
                .retrieve()
                .body(DeezerArtist.class);
        return deezerArtist;
    }
}
