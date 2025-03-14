package com.music.dto;

import com.music.entity.Artist;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TrackDTO {
    private Integer idDeezer;

    private String title;

    private String link;

    private Integer duration;

    private Integer rank;

    private ArtistDTO artistDTO;
}