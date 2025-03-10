package com.music.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class DeezerArtist {
    @Id
    private Integer id;
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
    private Integer nbAlbum;

    @JsonProperty("nb_fan")
    private Integer nbFan;
    private Boolean radio;
    private String tracklist;
    private String type;
}