using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;


namespace Podstawy
{
    class Program
    {
        static void Main(string[] args)
        {

            Car borysCar = new Car();
            borysCar.Color = "black";
            Car danielCar = new Car();
            danielCar.Color = "red";

            Console.WriteLine("Borys car: " + borysCar.Color);
            Console.WriteLine("Daniel car: " + danielCar.Color);

            borysCar = danielCar;                                       // kradnie obiekt
            Console.WriteLine("Borys car: " + borysCar.Color);

            borysCar.Color = "white";                               // zmienia color w obu autach
            Console.WriteLine("");

            Console.WriteLine("Borys car: " + borysCar.Color);
            Console.WriteLine("Daniel car: " + danielCar.Color);


            Console.ReadKey();
        }
    }
}
