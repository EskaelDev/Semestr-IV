package pw_03_hermetyzacjadziedziczenie_zawodnik;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tomek
 */
public class Sedzia extends Zawodnik {

    private int zolte;
    private int czerwone;

    public Sedzia(String _imie, String _nazwisko, int _wiek) {
        super(_imie, _nazwisko, _wiek);
        zolte = 0;
        czerwone = 0;
    }

    int IleZoltych() {
        return zolte;
    }

    int IleCzerwonych() {
        return czerwone;
    }

    void KolejnaZolta() {
        zolte++;
    }

    void KolejnaCzerwona() {
        czerwone++;
    }

    @Override
    void Wyswetl() {
        System.out.println("Imie: " + imie);
        System.out.println("Nazwisko: " + Nazwisko());
        System.out.println("Wiek: " + Wiek());
        System.out.println("Zoltych kartek: " + IleZoltych());
        System.out.println("Czerwonych kartek:  " + IleCzerwonych());
    }

}
