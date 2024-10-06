package com.example.AdnMutanteApi.logic;

public class dnaCheck {
    public static boolean isMutant(char[][] dnaMatrix){
        for (int i = 0; i < dnaMatrix.length; i++) {
            for (int j = 0; j < dnaMatrix[i].length; j++) {
                // Check rows for 4 matching characters
                if(j + 3 <= dnaMatrix[i].length && (dnaMatrix[i][j] == dnaMatrix[i][j+1] && dnaMatrix[i][j] == dnaMatrix[i][j+2] && dnaMatrix[i][j] == dnaMatrix[i][j+3])){
                    // System.out.println("Horizontal starting from " + i + ", " + j);
                    return true;
                }
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