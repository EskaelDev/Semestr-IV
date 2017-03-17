/**
 * Created by tomek on 17.03.2017.
 */
public class Okrag extends Figura {
    private double r;

    Okrag(double r) throws NiepoprawneDane {
        if (r <= 0) throw new NiepoprawneDane();
        else {
            this.r = r;
        }
    }

    @Override
    String KlasaFigury() {
        return "Okrag";
    }

    @Override
    double PolePowierzchni() {
        return Math.PI * r * r;
    }

    @Override
    double Obwod() {
        return 2 * Math.PI * r;
    }
}
