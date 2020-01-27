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

    public static int[][] Mystere(int[][] tab) {
        // Matrice : tableau d’entiers de 5 lignes et 6 colonnes
        // CONSTANTES
        final int NL=5,NC=6;
        for (int i = 0; i < NL; i++) {
            for (int j = 0; j < NC; j++) {
                tab[i][j] = 100 - tab[i][j];
            }
        }
        return tab;
    }

    public static int[][] ContrastPlus(int[][] tab) {
        // Matrice : tableau d’entiers de 5 lignes et 6 colonnes
        // CONSTANTES
        final int NL=5,NC=6;
        // VARIABLES
        int cp;
        
        for (int i = 0; i < NL; i++) {
            for (int j = 0; j < NC; j++) {
                if ( tab[i][j] > 75 ) {
                    cp = 100;
                } else if ( tab[i][j] > 50 ) {
                    cp = 75;
                } else {
                    cp = tab[i][j]/2;
                }
                tab[i][j] = cp;
            }
        }
        return tab;
    }
    
    public static int Moyenne(int[][] tab) {
        // Affiche Tableau Dimension 2 ordre 5 
        // CONSTANTES
        final int NL=5,NC=6;
        int somme = 0;
        for (int i = 0; i < NL; i++) {
            for (int j = 0; j < NC; j++) {
                somme = tab[i][j] + somme;
            }
        }
        return somme / (NL*NC);
    }
    
        public static int[][] ContrastMoins(int[][] tab) {
        // Matrice : tableau d’entiers de 5 lignes et 6 colonnes
        // CONSTANTES
        final int NL=5,NC=6;
        // VARIABLES
        int seuil = Moyenne(tab);
        
        int cm;
        
        for (int i = 0; i < NL; i++) {
            for (int j = 0; j < NC; j++) {
                cm = ( tab[i][j] - seuil ) / 2;
                tab[i][j] = tab[i][j] - cm;
            }
        }
        return tab;
    }
        
    public static void AfficheTableau(int[][] tab) {
        // Affiche Tableau Dimension 2 ordre 5 
        // CONSTANTES
        final int NL=5,NC=6;
        for (int i = 0; i < NL; i++) {
            System.out.println();
            for (int j = 0; j < NC; j++) {
                System.out.print(tab[i][j] + " \t");
            }
        }
    }
// fin main    
}
