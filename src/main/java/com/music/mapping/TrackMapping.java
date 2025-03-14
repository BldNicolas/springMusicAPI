package com.music.mapping;

import com.music.dto.TrackDTO;
import com.music.entity.Track;
import org.springframework.stereotype.Component;

@Component
public class TrackMapping {
    private final ArtistMapping artistMapping;

    public TrackMapping(ArtistMapping artistMapping) {
        this.artistMapping = artistMapping;
    }

    public Track dtoToEntity(TrackDTO trackDTO) {
        return Track.builder()
                .idDeezer(trackDTO.getIdDeezer())
                .title(trackDTO.getTitle())
                .link(trackDTO.getLink())
                .duration(trackDTO.getDuration())
                .rank(trackDTO.getRank())
                .artist(artistMapping.dtoToEntity(trackDTO.getArtistDTO()))
                .build();
    }

    public TrackDTO entityToDto(Track track) {
        return TrackDTO.builder()
                .idDeezer(track.getIdDeezer())
                .title(track.getTitle())
                .link(track.getLink())
                .duration(track.getDuration())
                .rank(track.getRank())
                .artistDTO(artistMapping.entityToDto(track.getArtist()))
                .build();
    }
}