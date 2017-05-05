using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Kalkulator
{
    public partial class Form1 : Form
    {
        Kalkulator kalkulator = new Kalkulator();
        string operacja;
        bool operationPressed = false, comaClicked = false, resultClicked = false, memoryClicked = false;

        public Form1()
        {
            InitializeComponent();
        }

        private void numberButtonClicked(object sender, EventArgs e)
        {
            if ((resultBox.Text == "0") || operationPressed || resultClicked|| memoryClicked)
            {
                resultBox.Clear();
                comaClicked = false;
            }
            operationPressed = false;
            resultClicked = false;
            memoryClicked = false;
            Button ClickedButton = (Button)sender;
            resultBox.Text += ClickedButton.Text;
        }

        private void operatorClick(object sender, EventArgs e)
        {
            Button ClickedButton = (Button)sender;
            operacja = ClickedButton.Text;
            kalkulator.previuos = Double.Parse(resultBox.Text);
            operationPressed = true;
            switch (ClickedButton.Text)
            {
                case "sqrt":
                    resultBox.Text = kalkulator.squareRoot().ToString();
                    break;
                case "+/-":
                    resultBox.Text = kalkulator.resign().ToString();
                    break;
                case "1/x":
                    try
                    {
                        resultBox.Text = kalkulator.reverse().ToString();
                    }
                    catch (DivideByZeroException divZero)
                    {
                        resultBox.Text = divZero.Message;
                    }
                    break;

            }
        }
        

        private void memoryClick(object sender, EventArgs e)
        {
            memoryClicked = true;
            Button memoButton = (Button)sender;
            switch (memoButton.Text)
            {
                case "M+":
                    kalkulator.memoryAdd(Double.Parse(resultBox.Text));
                    break;
                case "M-":
                    kalkulator.memorySubstract(Double.Parse(resultBox.Text));
                    break;
                case "MR":
                    resultBox.Text = kalkulator.memory.ToString();
                    break;
                case "MC":
                    kalkulator.memoryClear();
                    break;
            }
        }

        private void resultClick(object sender, EventArgs e)
        {
            //if(operationPressed)
            kalkulator.current = Double.Parse(resultBox.Text);
            switch (operacja)
            {
                case "+":
                    resultBox.Text = kalkulator.add().ToString();
                    break;
                case "-":
                    resultBox.Text = kalkulator.substract().ToString();
                    break;
                case "*":
                    resultBox.Text = kalkulator.multiplicate().ToString();
                    break;
                case "/":
                    try
                    {
                        resultBox.Text = kalkulator.divide().ToString();
                    }
                    catch (DivideByZeroException divZeroEx)
                    {
                        resultBox.Text = divZeroEx.Message;
                    }
                    break;
                case "%":
                    resultBox.Text = kalkulator.percent().ToString();
                    break;

                default:
                    break;
            }
            kalkulator.previuos = kalkulator.current;// Double.Parse(resultBox.Text);

            resultClicked = true;
        }

        private void comaClick(object sender, EventArgs e)
        {
            if (comaClicked == false)
                resultBox.Text += ",";
            comaClicked = true;
        }
    }
}
