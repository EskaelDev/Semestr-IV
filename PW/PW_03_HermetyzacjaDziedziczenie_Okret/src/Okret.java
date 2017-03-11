/**
 * Created by tomek on 11.03.2017.
 */
public abstract class Okret {
    protected static String Nazwa;
    protected static int Wypornosc;

    public Okret() {
    }

    public Okret(String nazwa, int wypornosc) {
        Nazwa = nazwa;
        Wypornosc = wypornosc;
    }

    public String getNazwa() {
        return Nazwa;
    }

    public int getWypornosc() {
        return Wypornosc;
    }

    abstract void Wyswietl();

}
