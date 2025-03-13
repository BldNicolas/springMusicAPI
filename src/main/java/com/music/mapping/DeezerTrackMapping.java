package com.music.mapping;

import com.music.dto.ArtistDTO;
import com.music.dto.TrackDTO;
import com.music.dto.DeezerTrackDTO;
import com.music.entity.Artist;
import org.springframework.stereotype.Component;

@Component
public class DeezerTrackMapping {
    private final DeezerArtistMapping deezerArtistMapping;
    private final ArtistMapping artistMapping;

    public DeezerTrackMapping(ArtistMapping artistMapping, DeezerArtistMapping deezerArtistMapping) {
        this.deezerArtistMapping = deezerArtistMapping;
        this.artistMapping = artistMapping;
    }

    public TrackDTO deezerTrackDTOToTrackDTO(DeezerTrackDTO deezerTrackDTO) {
        ArtistDTO artistDTO = deezerArtistMapping.deezerArtistDTOToArtistDTO(deezerTrackDTO.getArtist());
        Artist artist = artistMapping.dtoToEntity(artistDTO);
        return TrackDTO.builder()
                .idDeezer(deezerTrackDTO.getId())
                .title(deezerTrackDTO.getTitle())
                .link(deezerTrackDTO.getLink())
                .duration(deezerTrackDTO.getDuration())
                .rank(deezerTrackDTO.getRank())
                .artist(artist)
                .build();
    }
}