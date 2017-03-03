import java.util.Scanner;

public class Main {

    static float[][] wprowadzanieDancyh() {
        Scanner in = new Scanner(System.in);
        int x = 0, y = 0;
        loop:
        for (; ; ) {
            System.out.println("Podaj wymiary tablicy");
            System.out.print("X: ");
            x = in.nextInt();
            System.out.print("Y: ");
            y = in.nextInt();
            if (x > 0 && y > 0)
                break loop;
        }

        float[][] tab = new float[x][y];

        for (int i = 0; i < x; i++)
            for (int j = 0; j < y; j++) {
                System.out.println("Podaj wartość dla [" + i + "][" + j + "]:");
                tab[i][j] = in.nextFloat();
            }

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                System.out.printf("%5.2f", tab[i][j]);
            }
            System.out.println("");
        }
        // System.out.println(tab.length+" "+tab[0].length+" "+tab[1].length);

        return tab;
    }

    static float[][] mnozenieMaciezy(float[][] tab1, float[][] tab2) {

      /* if ((tab1[0].length != tab2[0].length) || (tab1[1].length != tab2[1].length)) {
            float[][] tab3 = new float[1][1];
            return tab3 = new float[1][1];
        } else {*/
        float[][] tab3 = new float[tab1.length][tab2[0].length];


        for (int i = 0; i < tab1.length; i++)
            for (int j = 0; j < tab2[0].length; j++)
                for (int k = 0; k < tab1[0].length; k++)
                    tab3[i][j] += tab1[i][k] * tab2[k][j];

        return tab3;
        // }
    }

    static void wyswietlanieMacierzy(float[][] tab) {
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[0].length; j++) {
                System.out.printf(" %5.2f ", tab[i][j]);
            }
            System.out.println("");
        }

    }

    public static void main(String[] args) {
        float[][] tab1 = wprowadzanieDancyh();
        float[][] tab2 = wprowadzanieDancyh();
        System.out.println("");

        wyswietlanieMacierzy(mnozenieMaciezy(tab1, tab2));
    }
}
