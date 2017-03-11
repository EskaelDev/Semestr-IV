/**
 * Created by tomek on 11.03.2017.
 */
public class OkretPodwodny extends Okret {
    private int WypornoscPodwodna;
    private int Wyrzutnie;

    OkretPodwodny(String nazwa, int wypornosc, int wypornoscPodwodna, int wyrzutnie) {
        super(nazwa, wypornosc);
        WypornoscPodwodna = wypornoscPodwodna;
        Wyrzutnie = wyrzutnie;
    }

    public int getWypornoscPodwodna() {
        return WypornoscPodwodna;
    }

    public int getWyrzutnie() {
        return Wyrzutnie;
    }

    int GlebokoscZanurzenia;

    void zanurz(int glebokoscZanurzenia) {
        GlebokoscZanurzenia = glebokoscZanurzenia;
    }

    int Zanurzenie() {
        return GlebokoscZanurzenia;
    }

    @Override
    void Wyswietl() {
        System.out.println("Nazwa: " + Nazwa);
        System.out.println("Wypornosc: " + Wypornosc);
        System.out.printf("Wypornosc podwodna: %d%n", WypornoscPodwodna);
        System.out.println("Ilosc wyrzutni: " + getWyrzutnie());

    }
}
