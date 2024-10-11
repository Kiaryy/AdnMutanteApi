package com.example.AdnMutanteApi.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.AdnMutanteApi.Exceptions.DnaFormatException;
import com.example.AdnMutanteApi.model.Human;
import com.example.AdnMutanteApi.model.Stats;
import com.example.AdnMutanteApi.repository.HumanRepository;
import static com.example.AdnMutanteApi.logic.dnaCheck.isMutant;
import java.util.List;

import java.time.LocalDate;

@Service
public class HumanService {
    
    //JPA repository
    @Autowired
    private HumanRepository humanRepository;

    public HumanService(HumanRepository humanRepository) {
        this.humanRepository = humanRepository;
    }
    public ResponseEntity<String> addHuman(List<String> dna) {
        try{
            boolean mutant = isMutant(dna.toArray(new String[0]));
            Human human = Human.builder()
                    .isMutant(mutant)
                    .dateAdded(LocalDate.now())
                    .build();
            humanRepository.save(human);
            if (mutant) {
                return new ResponseEntity<>("Mutant detected", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Not a mutant", HttpStatus.FORBIDDEN);
            }
        } catch(DnaFormatException e){ 
            System.out.println(e.getMessage());
            return new ResponseEntity<>("Invalid DNA format", HttpStatus.BAD_REQUEST);
        }
    }
    public Stats getStats(){
        List<Human> humans = humanRepository.findAll();
        int mutantCount = 0;
        int humanCount = 0;
        for (Human human : humans) {
            if (human.isMutant()){
                mutantCount ++;
            } else humanCount ++;
        }
        Double ratio = (double) mutantCount/humanCount;
        Stats stat = new Stats(mutantCount, humanCount, ratio);
        return stat;
    }
}
