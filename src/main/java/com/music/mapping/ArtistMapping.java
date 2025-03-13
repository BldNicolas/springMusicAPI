package com.music.mapping;

import com.music.dto.ArtistDTO;
import com.music.entity.Artist;
import org.springframework.stereotype.Component;

@Component
public class ArtistMapping {
    public Artist dtoToEntity(ArtistDTO artistDTO) {
        return Artist.builder()
                .idDeezer(artistDTO.getIdDeezer())
                .name(artistDTO.getName())
                .image(artistDTO.getImage())
                .nbAlbum(artistDTO.getNbAlbum())
                .build();
    }

    public ArtistDTO entityToDto(Artist artist) {
        return ArtistDTO.builder()
                .idDeezer(artist.getIdDeezer())
                .name(artist.getName())
                .image(artist.getImage())
                .nbAlbum(artist.getNbAlbum())
                .build();
    }
}