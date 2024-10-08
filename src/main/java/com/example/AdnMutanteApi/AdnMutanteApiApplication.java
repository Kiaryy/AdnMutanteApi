package com.example.AdnMutanteApi;
import static com.example.AdnMutanteApi.logic.dnaCheck.isMutant;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.AdnMutanteApi.Exceptions.DnaFormatException;

@SpringBootApplication
public class AdnMutanteApiApplication{
	public static void main(String[] args) {
		SpringApplication.run(AdnMutanteApiApplication.class, args);
		String[] dna = {"AGCCCT", "CATTGC", "TATTGT", "AAATGG", "TACACT", "TCACTG"};
		try {
			System.out.println(isMutant(dna));
		} catch (DnaFormatException e) {
			System.out.println(e.getMessage());
		}
	}
}