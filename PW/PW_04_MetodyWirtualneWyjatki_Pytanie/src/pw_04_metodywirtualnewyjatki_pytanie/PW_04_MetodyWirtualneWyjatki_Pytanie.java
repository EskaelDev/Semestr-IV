/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pw_04_metodywirtualnewyjatki_pytanie;

/**
 *
 * @author Tomek
 */
public class PW_04_MetodyWirtualneWyjatki_Pytanie {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Pytanie[] X = new Pytanie[7];

        try {
            X[0] = new JednoPytanie("Jaki jest Twoj ulubiony kolor", "niebieski", "czerwony", "zielony", 0);
            X[1] = new JednoPytanie("Ile masz lat", "10", "20", "30", 1);
            X[2] = new PytanieZlozone(2);
            ((PytanieZlozone) X[2]).UstawPytanie(0, new JednoPytanie("Blargh", "a", "b", "c", 2));
            ((PytanieZlozone) X[2]).UstawPytanie(1, new JednoPytanie("Czy kwiatki sa kolorowe", "TAK", "NIE", "NIE WIEM", 2));
            

        } catch (ZlePytanie P) {
            System.out.println("Nieprawidlowe parametry pytania");
        }
        int WYNIK = 0;
        for (int i = 0; i < X.length; i++) {
            if (X[i] != null) {
                WYNIK += X[i].Testuj();
            }
        }
        System.out.println("Wynik: " + WYNIK);
    }
}
