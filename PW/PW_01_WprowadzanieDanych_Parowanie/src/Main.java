import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        //System.out.println("Hello World!");
        Scanner in = new Scanner(System.in);
        float iloscSubstancji = 0;
        int ubytekSubstancji = 0;
        char c;

        loop:
        do
        {
            System.out.print("Ilosc substancji: ");
            iloscSubstancji = in.nextFloat();

            System.out.print("Codzienny ubytek (%): ");
            ubytekSubstancji = in.nextInt();

            if(iloscSubstancji < 5 || ubytekSubstancji < 0 || ubytekSubstancji > 100)
            {
                System.out.println("Błąd");
                System.out.print("Czy kontynuowac? t/n ");
                 c = in.next(".").charAt(0);
                if( c == 'n' )
                    break loop;
            }

        } while (iloscSubstancji < 5 || ubytekSubstancji < 0 || ubytekSubstancji > 100);

        System.out.println("|--------------------------------|");
        System.out.println("|  Dzien  |  Gramow  |  Procent  |");
        System.out.println("|--------------------------------|");
        int i = 1;
        float procent = 100;

        DecimalFormat df = new DecimalFormat("##.#");
        df.setRoundingMode(RoundingMode.CEILING);

        while(iloscSubstancji>1)
        {
           // System.out.println("|       "+i+" |   "+iloscSubstancji+"   |   "+df.format(procent)+"% |    ");
            System.out.print("|       " + i);
            System.out.print(" |   ");
            System.out.printf("%5.2f", iloscSubstancji);
            System.out.print("  |   ");
            System.out.printf("%5.1f", procent);
            System.out.println("%  |");

            i++;
            procent=procent/2;
            iloscSubstancji = iloscSubstancji*ubytekSubstancji/100;
        }
        System.out.print("|--------------------------------|");


    }
}
