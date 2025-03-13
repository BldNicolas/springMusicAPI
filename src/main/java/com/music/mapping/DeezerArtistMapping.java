package com.music.mapping;

import com.music.dto.ArtistDTO;
import com.music.dto.DeezerArtistDTO;
import org.springframework.stereotype.Component;

@Component
public class DeezerArtistMapping {
    public ArtistDTO deezerArtistDTOToArtistDTO(DeezerArtistDTO deezerArtistDTO) {
        return ArtistDTO.builder()
                .idDeezer(deezerArtistDTO.getId())
                .name(deezerArtistDTO.getName())
                .image(deezerArtistDTO.getPicture())
                .nbAlbum(deezerArtistDTO.getNbAlbum())
                .build();
    }

    public DeezerArtistDTO artistDTOToDeezerArtistDTO(ArtistDTO artistDTO) {
        return DeezerArtistDTO.builder()
                .id(artistDTO.getIdDeezer())
                .name(artistDTO.getName())
                .picture(artistDTO.getImage())
                .nbAlbum(artistDTO.getNbAlbum())
                .build();
    }
}
