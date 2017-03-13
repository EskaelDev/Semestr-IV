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
public class Gracz extends Zawodnik{
    private String nazwaKlubu;
    private int wartosc;

    public Gracz(String _imie, String _nazwisko, int _wiek, String nazwaKlubu) {
        super(_imie, _nazwisko, _wiek);
        this.nazwaKlubu=nazwaKlubu;
        this.wartosc=0;
    }
    String Klub()
    {return nazwaKlubu;}
    void ZmienKlub(String nazwaKlubu){
        this.nazwaKlubu=nazwaKlubu;
    }
    int Wartosc(){
        return wartosc;
    }
    void UstawWartosc(int wartosc){
        this.wartosc=wartosc;
    }
    
    
     @Override
    void Wyswetl() {
        System.out.println("Imie: " + imie);
        System.out.println("Nazwisko: " + Nazwisko());
        System.out.println("Wiek: " + Wiek());
        System.out.println("Nazwa klubu: " + Klub());
        System.out.println("Wartosc:  " + wartosc);
    }
}
