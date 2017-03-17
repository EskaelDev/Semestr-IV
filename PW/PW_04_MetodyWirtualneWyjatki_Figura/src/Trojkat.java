/**
 * Created by tomek on 17.03.2017.
 */
public class Trojkat extends Figura {
    private double a, b, c;

    Trojkat(double a, double b, double c) throws NiepoprawneDane {
        if (a <= 0 || b <= 0 || c <= 0) throw new NiepoprawneDane();
        else {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    @Override
    String KlasaFigury() {
        return "Trojkat";
    }

    @Override
    double PolePowierzchni() {
        return (Math.sqrt((a + b + c) * (a + b - c) * (a - b + c) * (-a + b + c))) / 4;
    }

    @Override
    double Obwod() {
        return a + b + c;
    }
}
