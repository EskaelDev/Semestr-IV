/**
 * Created by tomek on 17.03.2017.
 */
public class Prostokat extends Figura {

    private double a, b;

    Prostokat(double a, double b) throws NiepoprawneDane {
        if (a <= 0 || b <= 0)
            throw new NiepoprawneDane();
        else {
            this.a = a;
            this.b = b;
        }
    }

    @Override
    String KlasaFigury() {
        return "Prostokat";
    }

    @Override
    double PolePowierzchni() {
        return a * b;
    }

    @Override
    double Obwod() {
        return 2 * a + 2 * b;
    }
}
