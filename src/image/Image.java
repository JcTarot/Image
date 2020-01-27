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
        final int NL=5,NC=6;
        // VARIABLES
 
        // initialisation de la matrice image
        int[][] M = new int[][] {
                    {25,	28,	100,	100,	100,	100},
                    {44,	45,	50,	100,	100,	100},
                    {65,	65,	50,	20,	100,	100 },
                    {90,	62,	100,	5,	0,	0},
                    {60,	87,	100,	0,	100,	100}
                            }; 

        AfficheTableau(M);
        System.out.println("Matrice Image");
        // matrice image inversé pour image négative
        Mystere(M);
        AfficheTableau(M);
        System.out.println("Matrice Négative");
        // matrice image contrasté    
        ContrastPlus(M);
        AfficheTableau(M);
        System.out.println("Matrice Image Contrast Plus");
        // moyenne des valeurs de la matrice image   
        System.out.println();
        System.out.printf("\rMatrice Image Moyenne : %d", Moyenne(M));
        System.out.println();
        // matrice image désaturé
        ContrastMoins(M);
        AfficheTableau(M);
        System.out.println("Matrice Image Contrast Moins");
        // moyenne des valeurs de la matrice image   
        System.out.println();
        System.out.printf("\rMatrice Image Moyenne : %d", Moyenne(M));
        System.out.println();
    }

    public static int[][] Mystere(int[][] matrice) {
        // Matrice : tableau d’entiers de 5 lignes et 6 colonnes
        // CONSTANTES
        final int NL=5,NC=6;
        for (int i = 0; i < NL; i++) {
            for (int j = 0; j < NC; j++) {
                matrice[i][j] = 100 - matrice[i][j];
            }
        }
        return matrice;
    }

    public static int[][] ContrastPlus(int[][] matrice) {
        // Matrice : tableau d’entiers de 5 lignes et 6 colonnes
        // CONSTANTES
        final int NL=5,NC=6;
        // VARIABLES
        int cp;
        
        for (int i = 0; i < NL; i++) {
            for (int j = 0; j < NC; j++) {
                if ( matrice[i][j] > 75 ) {
                    cp = 100;
                } else if ( matrice[i][j] > 50 ) {
                    cp = 75;
                } else {
                    cp = matrice[i][j]/2;
                }
                matrice[i][j] = cp;
            }
        }
        return matrice;
    }
    
    public static int Moyenne(int[][] matrice) {
        // Moyenne du Tableau Dimension 2 ordre 5 
        // CONSTANTES
        final int NL=5,NC=6;
        int somme = 0;
        for (int i = 0; i < NL; i++) {
            for (int j = 0; j < NC; j++) {
                somme = matrice[i][j] + somme;
            }
        }
        return somme / (NL*NC);
    }
    
        public static int[][] ContrastMoins(int[][] matrice) {
        // Matrice : tableau d’entiers de 5 lignes et 6 colonnes
        // CONSTANTES
        final int NL=5,NC=6;
        // VARIABLES
        int seuil = Moyenne(matrice);
        
        int cm;
        
        for (int i = 0; i < NL; i++) {
            for (int j = 0; j < NC; j++) {
                cm = ( matrice[i][j] - seuil ) / 2;
                matrice[i][j] = matrice[i][j] - cm;
            }
        }
        return matrice;
    }
        
    public static void AfficheTableau(int[][] matrice) {
        // Affiche Tableau Dimension 2 ordre 5 
        // CONSTANTES
        final int NL=5,NC=6;
        for (int i = 0; i < NL; i++) {
            System.out.println();
            for (int j = 0; j < NC; j++) {
                System.out.print(matrice[i][j] + " \t");
            }
        }
    }
// fin main    
}
