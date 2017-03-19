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
public class PytanieZlozone extends Pytanie {

    JednoPytanie[] zbiorPytan;

    public PytanieZlozone(int n) {
        this.zbiorPytan = new JednoPytanie[n];
    }

    void UstawPytanie(int i, JednoPytanie p) throws ZlePytanie {
        if (zbiorPytan.length < i || p == null) {
            throw new ZlePytanie();
        }
        zbiorPytan[i] = p;
    }

    @Override
    public void Wyswietl() {
        for (int i = 0; i < zbiorPytan.length; i++) {
            if (zbiorPytan[i] != null) {
                zbiorPytan[i].Wyswietl();
            }
        }
    }

    @Override
    public int Testuj() {
        int wynik = 0;

        for (int i = 0; i < zbiorPytan.length; i++) {
            if (zbiorPytan[i] != null) {
                wynik += zbiorPytan[i].Testuj();
            }
        }
        return wynik;
    }

    @Override
    public int LiczbaPytan() {
        int l = 0;
        for (int i = 0; i < zbiorPytan.length; i++) {
            if (zbiorPytan[i] != null) {
                l++;
            }
        }
        return l;
    }

}
