package zad2pack;


public class DoubleCalculator {

    public double add(int a, int b )
    {
        return a + b;
    }

    public double sub(int a, int b )
    {
        return a - b;
    }

    public double multi(int a, int b)
    {
        return a * b;
    }

    int div(int a, int b)
    {
        return a/b;
    }
    boolean greater(int a, int b)
    {
        if (a>b) return true;
        else return false;
    }



    public DoubleCalculator()
    {
        System.out.println( " Konstruktor Calc: " + this);
    }


}