/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pw_02_podprogramyandtablice2;

import java.util.Scanner;

/**
 *
 * @author Tomek
 */
public class PW_02_PodprogramyAndTablice2 {

    /**
     * @param args the command line arguments
     */
    static float[][] wprowadznieDancyh() {
        int x = 0, y = 0;
        Scanner in = new Scanner(System.in);

        System.out.println("Podaj wymiary tabeli");
        System.out.println("x: ");
        x = in.nextInt();
        System.out.println("y: ");
        y = in.nextInt();

        float[][] tab = new float[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                System.out.println("Podaj wartość dla elementu [" + i + "] [" + j + "]: ");
                tab[i][j] = in.nextFloat();
            }
        }
        return tab;
    }

    static float[][] transpoowanieMacierzy(float[][] tab) {

        float[][] tabT = new float[tab[0].length][tab.length];
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[0].length; j++) {
                tabT[j][i] = tab[i][j];
            }
        }
        return tabT;
    }

    static void wyswietlanieMacierzy(float[][] tab) {
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[0].length; j++) {
                System.out.printf(" %5.2f ", tab[i][j]);
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        float[][] tab1 = wprowadznieDancyh();
        wyswietlanieMacierzy(tab1);
                    System.out.println("");

        wyswietlanieMacierzy(transpoowanieMacierzy(tab1));
    }

}
