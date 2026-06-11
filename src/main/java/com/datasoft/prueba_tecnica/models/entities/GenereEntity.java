package com.datasoft.prueba_tecnica.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "generes")
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @Builder
public class GenereEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30, nullable = false)
    private String name;

    @OneToMany(
            mappedBy = "genere",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true
    )
    @Builder.Default
    private List<BookEntity> books = new ArrayList<>();
}
