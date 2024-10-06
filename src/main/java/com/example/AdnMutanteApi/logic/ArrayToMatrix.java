package com.example.AdnMutanteApi.logic;

import com.example.AdnMutanteApi.Exceptions.DnaFormatException;

public class ArrayToMatrix {
    public static char[][] turnArrayToMatrix(String[] dna) throws DnaFormatException{
        // Error handling
        if (dna == null) throw new DnaFormatException("DnaFormatException: Expected an array with Strings, got null instead.");
        if (dna.length == 0) throw new DnaFormatException("DnaFormatException: Array is not populated.");
        if (dna[0] == null) throw new DnaFormatException("DnaFormatException: Element in index: " + 0 + " is null.");
        int widht = dna[0].length();
        // We check each string to see if they all have the same lenght
        char [][] dnaMatrix = new char[dna.length][];
        for (int i = 0; i < dna.length; i++) {
            if (dna[i] == null) throw new DnaFormatException("DnaFormatException: Element in index: " + i + " is null.");
            dna[i] = dna[i].toUpperCase();
            if (dna[i].length() != widht){ // Throws an exception if one of the strings has a different lenght (Matrix won't be square)
                throw new DnaFormatException("DnaFormatException: Each line needs to be the same lenght.");
            }            
            for(int j = 0; j<dna[i].length(); j++){ // Throws an exception if one of the strings contains any character other than T, A, C or G
                if (dna[i].charAt(j) != 'A' && dna[i].charAt(j) != 'T' && dna[i].charAt(j) != 'G' && dna[i].charAt(j) != 'C'){
                    throw new DnaFormatException("DnaFormatException: Characters have to be 'A, T, G or C'");
                }
            }
            dnaMatrix[i] = dna[i].toCharArray(); // We transform each string to an array of characers, and then we store it in a 2d array
        }
        return dnaMatrix;
    }
}
