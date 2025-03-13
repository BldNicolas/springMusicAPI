package com.music.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeezerArtistDTO {
    private Long id;

    private String name;

    private String link;

    private String share;

    private String picture;

    @JsonProperty("picture_small")
    private String pictureSmall;

    @JsonProperty("picture_medium")
    private String pictureMedium;

    @JsonProperty("picture_big")
    private String pictureBig;

    @JsonProperty("picture_xl")
    private String pictureXl;

    @JsonProperty("nb_album")
    private int nbAlbum;

    @JsonProperty("nb_fan")
    private int nbFan;

    private boolean radio;

    private String tracklist;

    private String type;
}
