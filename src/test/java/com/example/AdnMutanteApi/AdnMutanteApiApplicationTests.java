package com.example.AdnMutanteApi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static com.example.AdnMutanteApi.logic.dnaCheck.isMutant;
import com.example.AdnMutanteApi.Exceptions.DnaFormatException;

@SpringBootTest
class AdnMutanteApiApplicationTests {

	@Test
	void horizontalMutant() {
		String[] dna = {"AGCCCT",
						"CATTGC",
						"TATTGT",
						"AGATGG",
						"TGGGGT",
						"TCACTG"};
		try {
			boolean isMutant = isMutant(dna);
			Assertions.assertEquals(true, isMutant);
		} catch (DnaFormatException e) {
			System.out.println(e.getMessage());
		}
	}
	@Test
	void verticalMutant(){
		String[] dna = {"AGCCCT",
						"CCTTGC",
						"TATTGT",
						"AAATGG",
						"TACACT",
						"TAACTG"};
		try {
			boolean isMutant = isMutant(dna);
			Assertions.assertEquals(true, isMutant);
		} catch (DnaFormatException e) {
			System.out.println(e.getMessage());
		}
	}
	@Test
	void leftRightDiagonalMutant(){
		String[] dna = {"GGCCCT",
						"CATTGC",
						"TAATGT",
						"ATAAGG",
						"TACAAT",
						"TCACTG"};
		try {
			boolean isMutant = isMutant(dna);
			Assertions.assertEquals(true, isMutant);
		} catch (DnaFormatException e) {
			System.out.println(e.getMessage());
		}
	}
	@Test
	void rightLeftDiagonalMutant(){
		String[] dna = {"AGCCCT",
						"CATTTC",
						"TATTGT",
						"AGTTGG",
						"TTCACT",
						"ACACTG"};
		try {
			boolean isMutant = isMutant(dna);
			Assertions.assertEquals(true, isMutant);
		} catch (DnaFormatException e) {
			System.out.println(e.getMessage());
		}
	}
}
