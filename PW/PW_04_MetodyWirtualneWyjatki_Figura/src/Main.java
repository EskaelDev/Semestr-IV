public class Main {

    public static void main(String[] args) {
        try {
            Grupa G = new Grupa(20);
            Okrag o1 = new Okrag(2);
            G.UstawFigure(0, o1);
            Okrag o2 = new Okrag(6.66);
            G.UstawFigure(1, o2);
            Okrag o3 = new Okrag(7.2);
            G.UstawFigure(2, o3);
            Trojkat t1 = new Trojkat(2,3,4);
            G.UstawFigure(6, t1);
            Trojkat t2 = new Trojkat(3.12,4.1,5.86);
            G.UstawFigure(7, t2);
            Trojkat t3 = new Trojkat(6.66,6.66,6.66);
            G.UstawFigure(8, t3);
            Prostokat p1 = new Prostokat(2,3);
            G.UstawFigure(9, p1);
            Prostokat p2 = new Prostokat(1.12,2.22);
            G.UstawFigure(10, p2);
            Prostokat p3 = new Prostokat(6.66,6.66);
            G.UstawFigure(11, p3);
            System.out.println("Grupa figur: "+G.KlasaFigury());
            System.out.printf("Suma pól: %.2f\n" , G.PolePowierzchni());
            System.out.printf("Suma obwodów: %.2f\n",G.Obwod());
            System.out.println();
            G.Wyswietl();

        }catch (NiepoprawneDane e)
        {
            System.out.println("Błąd w utworzeniu nowej figury - niepoprawne dane!");
        }
    }
}
