package com.example.AdnMutanteApi.logic;

import com.example.AdnMutanteApi.Exceptions.FormatException;

public class dnaCheck {
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
    public static boolean isMutant(char[][] dnaMatrix){
        for (int i = 0; i < dnaMatrix.length; i++) {
            for (int j = 0; j < dnaMatrix[i].length; j++) {
                // Check rows for 4 matching characters
                if(j + 3 <= dnaMatrix[i].length && (dnaMatrix[i][j] == dnaMatrix[i][j+1] && dnaMatrix[i][j] == dnaMatrix[i][j+2] && dnaMatrix[i][j] == dnaMatrix[i][j+3])){
                    System.out.println("Horizontal in row " + i);
                    return true;
                }
                // Check columns for 4 matching characters
                if(i + 3 <= dnaMatrix.length && (dnaMatrix[i][j] == dnaMatrix[i+1][j] && dnaMatrix[i][j] == dnaMatrix[i+2][j] && dnaMatrix[i][j] == dnaMatrix[i+3][j])){
                    System.out.println("Vertical in column " + j);
                    return true;
                }
                // Check for 4 matching characters in a diagonal line (Left to Right)
                if(i + 3 <= dnaMatrix.length && j + 3 <= dnaMatrix[i].length &&(dnaMatrix[i][j] == dnaMatrix[i+1][j+1] && dnaMatrix[i][j] == dnaMatrix[i+2][j+2] && dnaMatrix[i][j] == dnaMatrix[i+3][j+3])){
                    System.out.println("Left to Right Diagonal starting from " + i +", " + j);
                    return true;
                }
                // Check for 4 matching characters in a diagonal line (Right to Left)
                if(i + 3 <= dnaMatrix.length && j - 3 >= 0 &&(dnaMatrix[i][j] == dnaMatrix[i+1][j-1] && dnaMatrix[i][j] == dnaMatrix[i+2][j-2] && dnaMatrix[i][j] == dnaMatrix[i+3][j-3])){
                    System.out.println("Right to Left Diagonal starting from " + i +", " + j);
                    return true;
                }
            }
        }
        return false;
    }
}
