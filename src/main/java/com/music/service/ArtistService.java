package com.music.service;

import com.music.entity.Artist;
import com.music.entity.DeezerArtist;
import com.music.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.beans.factory.annotation.Value;

@Service
public class ArtistService {

    private final RestClient restClient;
    private final String deezerUrl;

    @Autowired
    private final ArtistRepository artistRepository;

    public ArtistService(ArtistRepository artistRepository, ArtistMapping artistMapping, RestClient restClient, String deezerUrl) {
        this.artistRepository = artistRepository;
        this.restClient = RestClient.create();
        this.restClient = restClient;
    }

    public DeezerArtist bounceArtist(String name) {
        String url = deezerUrl + "/artist/" + name;
        DeezerArtist deezerArtist = restClient.get()
                .uri(url)
                .retrieve()
                .body(DeezerArtist.class);
        return deezerArtist;
    }

    public Artist scrapArtist(String name) {
        DeezerArtist deezerArtist = this.bounceArtist(name);
        Artist artist = this.convertDeezerArtistToArtist(deezerArtist);
        return artistRepository.save(artist);
    }

    public Artist convertDeezerArtistToArtist(DeezerArtist deezerArtist) {
        Artist artist = new Artist();
        artist.setId((long) deezerArtist.getId());
        artist.setName(deezerArtist.getName());
        artist.setImage(deezerArtist.getPicture());
        artist.setNbAlbum(deezerArtist.getNbAlbum());
        return artist;
    }

    public Artist getArtist(String name) {
        return artistRepository.findByName(name).orElse(null);
    }
}
