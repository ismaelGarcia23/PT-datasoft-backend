package com.datasoft.prueba_tecnica.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "books")
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @Builder
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private  String name;

    @Column(length = 500)
    private  String summary;

    @Column(precision = 6, scale = 2, nullable = false)
    private BigDecimal price;

    @Column(columnDefinition = "TEXT")
    private  String image;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gen_id", nullable = false)
    private GenereEntity genere;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usr_id", nullable = false)
    private UserEntity user;
}
