using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MS_02_Klasy_Struktury
{
    class Car
    {
        private string _brand;
        public string Brand
        {
            get { return _brand; }
            set { _brand = value; }
        }

        public string Color { get; set; }

        public Car(string brand, string color)
        {
            _brand = brand;
            Color = color;
        }

        public void DisplayBrand()
        {
            Console.WriteLine("Marka auta to: {0}", _brand);
        }
    }
}
