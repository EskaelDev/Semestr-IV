import java.util.*;

public class Main {

    public static void main(String[] args) {
        OkretPodwodny nazwa = new OkretPodwodny("Kozak", 100, 200, 20);
        nazwa.Wyswietl();
        nazwa.zanurz(20);
        System.out.println("Zanurzenie: " + nazwa.Zanurzenie());

        System.out.println();

        OkretNawodny nazwa2 = new OkretNawodny("Hej", 100, 200, 12);
        nazwa2.Wyswietl();

        if (nazwa2.CzyZakotwiczony()) {
            System.out.println("Okret zakotwiczony");
        }
        nazwa2.RzucKotwice();

        if (nazwa2.CzyZakotwiczony()) {
            System.out.println("Okret zakotwiczony");
        }
        nazwa2.PodniesKotwice();
        if (nazwa2.CzyZakotwiczony()) {
            System.out.println("Okret zakotwiczony");
        }
    }
}
