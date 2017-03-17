/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pw_03_hermetyzacjadziedziczenie_zawodnik;

/**
 *
 * @author Tomek
 */
public class PW_03_HermetyzacjaDziedziczenie_Zawodnik {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Sedzia sedzia1 = new Sedzia("Imie1", "Nazwisko1", 31);
        Sedzia sedzia2 = new Sedzia("Imie2", "Nazwisko2", 31);
        sedzia1.Wyswetl();

        System.out.println("");

        sedzia1.KolejnaZolta();
        sedzia1.KolejnaCzerwona();
        sedzia1.Wyswetl();

        System.out.println("");

        sedzia2.Wyswetl();

        System.out.println("");

        Gracz gracz1 = new Gracz("Imie1", "Nazwisko1", 22, "ArkaGdyniaKurwaSwinia");
        gracz1.Wyswetl();

        System.out.println("");

        gracz1.UstawWartosc(1000);
        gracz1.Wyswetl();

        System.out.println("");

        gracz1.ZmienKlub("Jarosze KZK Smiecie");
        gracz1.Wyswetl();
    }

}
