/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package image;

/**
 *
 * @author Jean-Christophe Tarot formation_ep
 */
public class Image {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // CONSTANTES
        final int NL=2,NC=2;
        // VARIABLES

        // initialisation de la matrice image
        int[][] M = new int[][] {
                                    {5,0},
                                    {0,100}
                                    };       
        AfficheTableau(M);            
    }

        

    
    public static void AfficheTableau(int[][] tab) {
        // Affiche Tableau Dimension 2 ordre 5 
        for (int i = 0; i < 2; i++) {
            System.out.println();
            for (int j = 0; j < 2; j++) {
                System.out.print(tab[i][j] + " ");
            }
        }
    }
}
