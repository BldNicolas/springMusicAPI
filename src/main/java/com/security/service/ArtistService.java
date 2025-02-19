package com.security.service;

import com.security.entity.Artist;
import com.security.entity.DeezerArtist;
import com.security.repository.ArtistRepository;
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

    public ArtistService(@Value("${deezer.url}") String deezerUrl, ArtistRepository artistRepository) {
        this.deezerUrl = deezerUrl;
        this.artistRepository = artistRepository;
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
}
