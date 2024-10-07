package com.example.AdnMutanteApi.logic;

import com.example.AdnMutanteApi.Exceptions.DnaFormatException;

public class dnaCheck {
    private static final int MIN_SEQUENCE = 4;
    // We transform the 1d array into a 2d array
    public static boolean isMutant(String[] dna)throws DnaFormatException{
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
            // Checks if the current line contains the sequence
            if (dna[i].contains("A".repeat(MIN_SEQUENCE)) || dna[i].contains("T".repeat(MIN_SEQUENCE)) || dna[i].contains("G".repeat(MIN_SEQUENCE)) || dna[i].contains("C".repeat(MIN_SEQUENCE))){
                System.out.println("Horizontal starting from " + i);
                return true;
            }
            
            // Throws an exception if one of the strings has a different lenght (Matrix won't be square)
            if (dna[i].length() != widht){ 
                throw new DnaFormatException("DnaFormatException: Each line needs to be the same lenght.");
            }            
            for(int j = 0; j<dna[i].length(); j++){ // Throws an exception if one of the strings contains any character other than T, A, C or G
                if (dna[i].charAt(j) != 'A' && dna[i].charAt(j) != 'T' && dna[i].charAt(j) != 'G' && dna[i].charAt(j) != 'C'){
                    throw new DnaFormatException("DnaFormatException: Characters have to be 'A, T, G or C'");
                }
            }
            dnaMatrix[i] = dna[i].toCharArray(); // We transform each string to an array of characers, and then we store it in a 2d array
        }
        // Dna Checking
        for (int i = 0; i < dnaMatrix.length-MIN_SEQUENCE; i++) {
            for (int j = 0; j < dnaMatrix[i].length-MIN_SEQUENCE; j++) {
                // Check columns for 4 matching characters
                if(i + 3 <= dnaMatrix.length && (dnaMatrix[i][j] == dnaMatrix[i+1][j] && dnaMatrix[i][j] == dnaMatrix[i+2][j] && dnaMatrix[i][j] == dnaMatrix[i+3][j])){
                    // System.out.println("Vertical strating from " + j + ", " + i);
                    return true;
                }
                // Check for 4 matching characters in a diagonal line (Left to Right)
                if(i + 3 <= dnaMatrix.length && j + 3 <= dnaMatrix[i].length &&(dnaMatrix[i][j] == dnaMatrix[i+1][j+1] && dnaMatrix[i][j] == dnaMatrix[i+2][j+2] && dnaMatrix[i][j] == dnaMatrix[i+3][j+3])){
                    // System.out.println("Left to Right Diagonal starting from " + i +", " + j);
                    return true;
                }
                // Check for 4 matching characters in a diagonal line (Right to Left)
                if(i + 3 <= dnaMatrix.length && j - 3 >= 0 &&(dnaMatrix[i][j] == dnaMatrix[i+1][j-1] && dnaMatrix[i][j] == dnaMatrix[i+2][j-2] && dnaMatrix[i][j] == dnaMatrix[i+3][j-3])){
                    // System.out.println("Right to Left Diagonal starting from " + i +", " + j);
                    return true;
                }
            }
        }
        return false;
    }
}