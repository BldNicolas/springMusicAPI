package com.music.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArtistDTO {
    private Integer idDeezer;

    private String name;

    private String image;

    private Integer nbAlbum;
}