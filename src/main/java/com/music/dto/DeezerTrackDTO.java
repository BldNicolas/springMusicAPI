package com.music.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeezerTrackDTO {
    private Integer id;

    private boolean readable;

    private String title;

    @JsonProperty("title_short")
    private String titleShort;

    @JsonProperty("title_version")
    private String titleVersion;

    private String isrc;

    private String link;

    private String share;

    private Integer duration;

    @JsonProperty("track_position")
    private Integer trackPosition;

    @JsonProperty("disk_number")
    private Integer diskNumber;

    private Integer rank;

    @JsonProperty("release_date")
    private String releaseDate;

    @JsonProperty("explicit_lyrics")
    private boolean explicitLyrics;

    @JsonProperty("explicit_content_lyrics")
    private Integer explicitContentLyrics;

    @JsonProperty("explicit_content_cover")
    private Integer explicitContentCover;

    private String preview;

    private Integer bpm;

    private Double gain;

    @JsonProperty("available_countries")
    private List<String> availableCountries;

    private List<DeezerArtistDTO> contributors;

    @JsonProperty("md5_image")
    private String md5Image;

    @JsonProperty("track_token")
    private String trackToken;

    private DeezerArtistDTO artist;
}