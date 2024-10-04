package com.example.AdnMutanteApi.logic;


public class dnaCheck {
    public static char[][] turnArrayToMatrix(String[] dna){
        int widht = dna[0].length();
        // We check each string to see if they all have the same lenght
        for (int i = 1; i < dna.length; i++) {
            if (dna[i].length() != widht){
                System.out.println("Formato incorrecto, cada fila de adn debe tener la misma cantidad de caracteres.");
                return null;
            }            
        }
        char [][] dnaMatrix = new char[dna.length][];
        for (int i = 0; i < dnaMatrix.length; i++) {
            dnaMatrix[i] = dna[i].toCharArray(); // We transform each string to an array of characers, and then we store it in a 2d array
        }
        return dnaMatrix;
    }
    public static boolean isMutant(char[][] dnaMatrix){
        if (dnaMatrix == null) {
            return false;
        }
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
                //TODO Check for 4 matching characters in a diagonal line
            }
        }
        return false;
    }
}
