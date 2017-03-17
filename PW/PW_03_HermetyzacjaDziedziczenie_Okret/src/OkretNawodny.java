/**
 * Created by tomek on 11.03.2017.
 */
public class OkretNawodny extends Okret {

    protected int LiczbaWiez;
    private int Zasieg;

    OkretNawodny(String nazwa, int wypornosc, int liczbaWiez, int zasieg) {
        super(nazwa, wypornosc);
        LiczbaWiez = liczbaWiez;
        Zasieg = zasieg;
    }

    int getZasieg() {
        return Zasieg;
    }

    int getLiczbaWiez() {
        return LiczbaWiez;
    }

    private boolean KotwicaZrzucona;

    void RzucKotwice() {
        KotwicaZrzucona = true;
    }

    void PodniesKotwice() {
        KotwicaZrzucona = false;
    }

    boolean CzyZakotwiczony() {
        return KotwicaZrzucona;
    }


    void Wyswietl() {
        System.out.println("Nazwa: " + Nazwa);
        System.out.println("Wypornosc: " + Wypornosc);
        System.out.println("Liczba wiez artylerii: " + LiczbaWiez);
        System.out.println("Zasieg: " + Zasieg);

    }
}
