/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pw_04_metodywirtualnewyjatki_pytanie;

import java.io.Console;
import java.util.Scanner;
import oracle.jrockit.jfr.tools.ConCatRepository;

/**
 *
 * @author Tomek
 */
public class JednoPytanie extends Pytanie {

    private String trescPytania;
    private String[] mozliweOpowiedzi = new String[3];
    private int numerOdpowiedzi;

    JednoPytanie(String trescPytania, String Odp1, String Odp2, String Odp3, int numerOdpowiedzi) throws ZlePytanie {
        if (trescPytania == null
                || Odp1 == null
                || Odp2 == null
                || Odp3 == null
                || numerOdpowiedzi < 0
                || numerOdpowiedzi > 2) {
            throw new ZlePytanie();
        }
        {
            this.mozliweOpowiedzi[0] = Odp1;
            this.mozliweOpowiedzi[1] = Odp2;
            this.mozliweOpowiedzi[2] = Odp3;
            this.trescPytania = trescPytania;
            this.numerOdpowiedzi = numerOdpowiedzi;
        }
    }

    public int getNumerOdpowiedzi() {
        return numerOdpowiedzi;
    }

    @Override
    public void Wyswietl() {
        System.out.println(trescPytania);
        System.out.println("1: " + mozliweOpowiedzi[0]);
        System.out.println("2: " + mozliweOpowiedzi[1]);
        System.out.println("3: " + mozliweOpowiedzi[2]);

    }

    @Override
    public int Testuj() {
        Scanner in = new Scanner(System.in);
        int wybor = 0;
        System.out.println(trescPytania);
        while (wybor < 1 || wybor > 3) {
            System.out.println("Podaj numer odowiedzi: ");
            wybor = in.nextInt();
        }
        if (wybor == numerOdpowiedzi) {
            return 1;
        }
        return 0;
    }

    @Override
    public int LiczbaPytan() {
        return 1;
    }

}
