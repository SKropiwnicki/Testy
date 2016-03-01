package zad1pack;

/**
 * Created by Kasiunia on 2016-03-01.
 */
public class Calculator {

    public int add(int a, int b )
    {
        return a + b;
    }

    public int sub(int a, int b )
    {
        return a - b;
    }

    int multi(int a, int b)
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



    public Calculator()
    {
        System.out.println( " Konstruktor Calc: " + this);
    }


}