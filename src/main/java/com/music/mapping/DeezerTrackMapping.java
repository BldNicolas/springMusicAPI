package com.music.mapping;

import com.music.dto.ArtistDTO;
import com.music.dto.TrackDTO;
import com.music.dto.DeezerTrackDTO;
import com.music.entity.Artist;
import org.springframework.stereotype.Component;

@Component
public class DeezerTrackMapping {
    private final DeezerArtistMapping deezerArtistMapping;

    public DeezerTrackMapping(DeezerArtistMapping deezerArtistMapping) {
        this.deezerArtistMapping = deezerArtistMapping;
    }

    public TrackDTO deezerTrackDTOToTrackDTO(DeezerTrackDTO deezerTrackDTO) {
        ArtistDTO artistDTO = deezerArtistMapping.deezerArtistDTOToArtistDTO(deezerTrackDTO.getArtist());
        return TrackDTO.builder()
                .idDeezer(deezerTrackDTO.getId())
                .title(deezerTrackDTO.getTitle())
                .link(deezerTrackDTO.getLink())
                .duration(deezerTrackDTO.getDuration())
                .rank(deezerTrackDTO.getRank())
                .artistDTO(artistDTO)
                .build();
    }
}