package com.example.AdnMutanteApi.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Stats {
    private int mutantCount;
    private int humanCount;
    private Double mutantToHumanRatio;
    @Builder
    public Stats(int mutantCount, int humanCount, Double mutantToHumanRatio) {
        this.mutantCount = mutantCount;
        this.humanCount = humanCount;
        this.mutantToHumanRatio = mutantToHumanRatio;
    }
    
}
