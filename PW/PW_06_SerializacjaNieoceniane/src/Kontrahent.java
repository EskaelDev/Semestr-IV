
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tomek
 */
public class Kontrahent implements Serializable{
    private String nazwa;
    private String adres;
    private String vat;
    private String kapital;
    private String zadluzenie;

    public Kontrahent(String nazwa, String adres, String vat, String kapital, String zadluzenie) {
        this.nazwa = nazwa;
        this.adres = adres;
        this.vat = vat;
        this.kapital = kapital;
        this.zadluzenie = zadluzenie;
    }

    public String getNazwa() {
        return nazwa;
    }

    public String getAdres() {
        return adres;
    }

    public String getVat() {
        return vat;
    }

    public String getKapital() {
        return kapital;
    }

    public String getZadluzenie() {
        return zadluzenie;
    }
    
}
