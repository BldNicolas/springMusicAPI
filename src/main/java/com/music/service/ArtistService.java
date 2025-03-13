package com.music.service;

import com.music.dto.ArtistDTO;
import com.music.dto.DeezerArtistDTO;
import com.music.entity.Artist;
import com.music.mapping.ArtistMapping;
import com.music.mapping.DeezerArtistMapping;
import com.music.repository.ArtistRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.beans.factory.annotation.Value;

@Service
public class ArtistService {
    private final ArtistRepository artistRepository;
    private final ArtistMapping artistMapping;
    private final RestClient restClient;
    private final DeezerArtistMapping deezerArtistMapping;

    @Value("${deezer.url}")
    private String deezerUrl;

    public ArtistService(ArtistRepository artistRepository, ArtistMapping artistMapping, RestClient restClient, DeezerArtistMapping deezerArtistMapping) {
        this.artistRepository = artistRepository;
        this.artistMapping = artistMapping;
        this.restClient = restClient;
        this.deezerArtistMapping = deezerArtistMapping;
    }

    public ArtistDTO bounce(String name) {
        String url = deezerUrl + "/artist/" + name;

        DeezerArtistDTO deezerArtistDTO = restClient.get()
                .uri(url)
                .retrieve()
                .body(DeezerArtistDTO.class);

        ArtistDTO artistDTO = deezerArtistMapping.deezerArtistDTOToArtistDTO(deezerArtistDTO);
        return artistDTO;
    }

    public ArtistDTO scrap(String name) {
        ArtistDTO artistDTO = this.bounce(name);
        Artist artist = artistMapping.dtoToEntity(artistDTO);
        Artist savedArtist = artistRepository.save(artist);
        return artistMapping.entityToDto(savedArtist);
    }

    public ArtistDTO get(String name) {
        Artist artist = artistRepository.findByName(name).orElse(null);
        return artistMapping.entityToDto(artist);
    }
}
