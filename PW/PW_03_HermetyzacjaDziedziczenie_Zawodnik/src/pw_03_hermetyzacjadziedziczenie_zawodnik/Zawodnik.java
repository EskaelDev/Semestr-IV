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
public abstract class Zawodnik {

    protected String imie;
    private final String nazwisko;
    private int wiek;
    Zawodnik(String _imie, String _nazwisko, int _wiek){
        imie = _imie;
        nazwisko = _nazwisko;
        wiek = _wiek;
    }
    String Imie(){return imie;};
    String Nazwisko(){return nazwisko;};
    int Wiek(){return wiek;};
    
    abstract void Wyswetl();
      
    

}
