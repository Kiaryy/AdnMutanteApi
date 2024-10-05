package com.example.AdnMutanteApi;
import static com.example.AdnMutanteApi.logic.dnaCheck.isMutant;
import static com.example.AdnMutanteApi.logic.ArrayToMatrix.turnArrayToMatrix;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AdnMutanteApiApplication{
	public static void main(String[] args) {
		SpringApplication.run(AdnMutanteApiApplication.class, args);
		String[] dna = {"ACCCCT","CATTGC","TATTGT","AAATGG","TACACT","TCACTG"};
		try {
			System.out.println(isMutant(turnArrayToMatrix(dna)));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}