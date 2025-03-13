package com.music.mapping;

import com.music.dto.TrackDTO;
import com.music.entity.Track;
import org.springframework.stereotype.Component;

@Component
public class TrackMapping {
    public Track dtoToEntity(TrackDTO trackDTO) {
        return Track.builder()
                .idDeezer(trackDTO.getIdDeezer())
                .title(trackDTO.getTitle())
                .link(trackDTO.getLink())
                .duration(trackDTO.getDuration())
                .rank(trackDTO.getRank())
                .artist(trackDTO.getArtist())
                .build();
    }

    public TrackDTO entityToDto(Track track) {
        return TrackDTO.builder()
                .idDeezer(track.getIdDeezer())
                .title(track.getTitle())
                .link(track.getLink())
                .duration(track.getDuration())
                .rank(track.getRank())
                .artist(track.getArtist())
                .build();
    }
}