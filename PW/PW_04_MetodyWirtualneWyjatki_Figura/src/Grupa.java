/**
 * Created by tomek on 17.03.2017.
 */
public class Grupa extends Figura {
    private Figura[] tablica;


    Grupa(int n) throws NiepoprawneDane {
        if (n <= 0) throw new NiepoprawneDane();
        else {
            tablica = new Figura[n];
        }
    }

    void UstawFigure(int i, Figura figura) throws NiepoprawneDane {
        if (i < 0 || i > tablica.length) {
            throw new NiepoprawneDane();
        }
        tablica[i] = figura;

    }

    public void Wyswietl() {

        System.out.println("Numer  |  Nazwa figury  |  Obwod  |  Pole powierzchni  |");
        for (int i = 0; i < tablica.length; i++)
            if (tablica[i] != null)
                System.out.printf("[%2d]   |  %9s     |  %6.2f |  %6.2f            |\n",
                        i, tablica[i].KlasaFigury(), tablica[i].Obwod(), tablica[i].PolePowierzchni());
    }

    @Override
    String KlasaFigury() {
        return "GrupaFigur";
    }

    @Override
    double PolePowierzchni() {
        double pole = 0;
        for (Figura fig : tablica) {
            if (fig != null)
                pole += fig.PolePowierzchni();
        }
        return pole;
    }

    @Override
    double Obwod() {
        double obwod = 0;
        for (Figura fig : tablica) {
            if (fig != null)
                obwod += fig.Obwod();
        }
        return obwod;
    }
}
