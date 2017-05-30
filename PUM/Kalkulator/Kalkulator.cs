using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Kalkulator
{
    class Kalkulator
    {
        private double previousNumber;
        private double currentNumber;

        public double memory;
        public double previuos { get { return previousNumber; } set { previousNumber = value; } }
        public double current { get { return currentNumber; } set { currentNumber = value; } }


        public Kalkulator()
        {
            previousNumber = currentNumber = memory = 0;
        }

        public double add()
        {
            return currentNumber + previousNumber;
        }

        public double substract()
        {
            return  previousNumber - currentNumber;
        }

        public double multiplicate()
        {
            return currentNumber * previousNumber;
        }

        public double divide()
        {
            if (currentNumber == 0)
                throw new DivideByZeroException();
            return previousNumber / currentNumber;
        }

        public double resign()
        {
            return previousNumber * -1;
        }

        public double reverse()
        {
            if (previousNumber == 0)
                throw new DivideByZeroException();
            return 1 / previousNumber;
        }

        public double squareRoot()
        {
            return Math.Sqrt(previousNumber);
        }
        public double percent()
        {
            return multiplicate() / 100;
        }

        public void memoryClear()
        {
            memory = 0;
        }

        public void memoryAdd(double number)
        {
            memory += number;
        }

        public void memorySubstract(double number)
        {
            memory -= number;
        }
        public void memoryRecord()
        {
            currentNumber = memory;
        }

    }
}
