/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pw_05_swingpierwszenieocieniane;

/**
 *
 * @author Tomek
 */
public class Pracownik {
    private String imie;
    private String nazwisko;
    private String placa;

    public Pracownik(String imie, String nazwisko, String placa) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.placa = placa;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
    
}
