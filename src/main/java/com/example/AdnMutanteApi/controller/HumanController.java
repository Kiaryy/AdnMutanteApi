package com.example.AdnMutanteApi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.AdnMutanteApi.model.DnaRequest;
import com.example.AdnMutanteApi.model.Stats;
import com.example.AdnMutanteApi.service.HumanService;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@RestController
public class HumanController {

    private final HumanService humanService;
    @PostMapping("/mutant")
    public ResponseEntity<String> addHuman(@RequestBody DnaRequest dnarRequest){
        return humanService.addHuman(dnarRequest);
    }
    @GetMapping("/stats")
    public ResponseEntity<Stats> getStats(){
        return ResponseEntity.ok(humanService.getStats());
    }
}
