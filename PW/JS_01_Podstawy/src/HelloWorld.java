import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by tomek on 10.02.2017.
 */
public class HelloWorld {
    public static String pnr = "Program ";
    public static int count=1;
    public static void prg()
    {
        System.out.println("\n"+pnr+count);
        count++;
    }
    public static void main(String[] args) throws FileNotFoundException
    {
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        prg();

        String jeden = "Ania z Darkiem";
        String razem = jeden.substring(0, 5)+"z Anetą";

        System.out.println(razem);
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        prg();
        double potega = Math.pow(2, 4);
        double pierwiastek = Math.sqrt(potega);
        double pi = Math.PI;
        double e = Math.E;

        System.out.println(potega+"\n"+pierwiastek);
        System.out.println(pi+" "+e);
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        prg();
        BigInteger a = new BigInteger("123456789012345678901234567890"),
                   b = new BigInteger("987654321098765432109876543210"),
                   suma = a.add(b);
        System.out.println("Suma: "+suma.toString());
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
         prg();/*Odczytanie z wiersza poleceń*/
         String Imie;
        Scanner odczyt = new Scanner(System.in);

        Imie = odczyt.nextLine();

        System.out.println("Witaj "+Imie);
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        prg();/*Zapis i odczyt z pliku*/
        PrintWriter zapis_p = new PrintWriter("plik.txt");
        zapis_p.println("Ala ma kota, a kot ma padaczkę");
        zapis_p.close();

        File plik = new File("plik.txt");
        odczyt = new Scanner(plik);
        Scanner odczyt_p = new Scanner(plik);

        String zdanie = odczyt.nextLine();
        System.out.println(zdanie);
        //System.out.println((String)odczyt.nextLine());
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        prg();/*Dynamiczna i statyczna tablica 1D*/
        int[] tab_int = new int[10];

        for(int licznik = 0; licznik<10;licznik++)
            tab_int[licznik] = licznik+1;
        for(int licznik = 0; licznik<10;licznik++)
            System.out.println(tab_int[licznik]);

        int ilosc;
        Scanner odczyt_ilosc = new Scanner(System.in);
        ilosc = odczyt_ilosc.nextInt();

        int[] tablica_ilosc = new int[ilosc];

        for(int licznik = 0;licznik<ilosc;licznik++)
            tablica_ilosc[licznik] = ilosc-licznik;
        for(int licznik = 0;licznik<ilosc;licznik++)
            System.out.println(tablica_ilosc[licznik]);
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        prg();/*Petla for each*/
        int[] tablica_each = new int[10];
        for(int licznik = 0;licznik<10; licznik++)
            tablica_each[licznik] = licznik + 1;

        for(int x : tablica_each)
            System.out.println(x);

    }


}
