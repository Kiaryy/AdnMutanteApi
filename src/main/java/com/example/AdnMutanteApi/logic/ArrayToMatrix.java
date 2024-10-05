package com.example.AdnMutanteApi.logic;

import com.example.AdnMutanteApi.Exceptions.FormatException;

public class ArrayToMatrix {
        public static char[][] turnArrayToMatrix(String[] dna) throws FormatException{
        int widht = dna[0].length();
        // We check each string to see if they all have the same lenght
        char [][] dnaMatrix = new char[dna.length][];
        for (int i = 0; i < dna.length; i++) {
            dna[i] = dna[i].toUpperCase();
            if (dna[i].length() != widht){ // Throws an exception if one of the strings has a different lenght (Matrix won't be square)
                throw new FormatException("Formato incorrecto, cada fila de adn debe tener la misma cantidad de caracteres.");
            }            
            for(int j = 0; j<dna[i].length(); j++){ // Throws an exception if one of the strings contains any character other than T, A, C or G
                if (dna[i].charAt(j) != 'A' && dna[i].charAt(j) != 'T' && dna[i].charAt(j) != 'G' && dna[i].charAt(j) != 'C'){
                    throw new FormatException("Formato incorrecto, caraceteres deben ser 'A, T, G o C'");
                }
            }
            dnaMatrix[i] = dna[i].toCharArray(); // We transform each string to an array of characers, and then we store it in a 2d array
        }
        return dnaMatrix;
    }
}
