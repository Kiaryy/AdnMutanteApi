package com.example.AdnMutanteApi.model;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Human{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long humanId;
    private boolean isMutant;
    private LocalDate dateAdded;
    
    @Builder
    public Human(Long humanId, boolean isMutant, LocalDate dateAdded) {
        this.humanId = humanId;
        this.isMutant = isMutant;
        this.dateAdded = LocalDate.now();
    }

}