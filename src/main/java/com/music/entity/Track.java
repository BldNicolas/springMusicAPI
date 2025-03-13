package com.music.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tracks")
public class Track {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer idDeezer;

    private String title;

    private String link;

    private Integer duration;

    private Integer rank;

    @ManyToOne
    @JoinColumn(name = "id_artist", nullable = false)
    private Artist artist;
}