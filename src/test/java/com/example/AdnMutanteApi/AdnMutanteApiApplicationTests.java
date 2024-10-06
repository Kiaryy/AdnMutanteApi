package com.example.AdnMutanteApi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static com.example.AdnMutanteApi.logic.dnaCheck.isMutant;
import static com.example.AdnMutanteApi.logic.ArrayToMatrix.turnArrayToMatrix;
import com.example.AdnMutanteApi.Exceptions.DnaFormatException;

@SpringBootTest
class AdnMutanteApiApplicationTests {

	@Test
	void horizontalMutant() {
		String[] dna = {"CCCC", "CATG", "TGCA","GGCA"};
		try {
			boolean isMutant = isMutant(turnArrayToMatrix(dna));
			Assertions.assertEquals(true, isMutant);
		} catch (DnaFormatException e) {
			System.out.println(e.getMessage());
		}
	}
	@Test
	void verticalMutant(){
		String[] dna = {"ATGC", "GTCA", "CTAA","GTCG"};
		try {
			boolean isMutant = isMutant(turnArrayToMatrix(dna));
			Assertions.assertEquals(true, isMutant);
		} catch (DnaFormatException e) {
			System.out.println(e.getMessage());
		}
	}
	@Test
	void leftRightDiagonalMutant(){
		String[] dna = {"AGGC", "GACA", "CTAC","CTGA"};
		try {
			boolean isMutant = isMutant(turnArrayToMatrix(dna));
			Assertions.assertEquals(true, isMutant);
		} catch (DnaFormatException e) {
			System.out.println(e.getMessage());
		}
	}
	@Test
	void rightLeftDiagonalMutant(){
		String[] dna = {"AGGC", "GACA", "CCGC","CTGA"};
		try {
			boolean isMutant = isMutant(turnArrayToMatrix(dna));
			Assertions.assertEquals(true, isMutant);
		} catch (DnaFormatException e) {
			System.out.println(e.getMessage());
		}
	}
}
