package main;

public class CostCalculator {

    public static int calculate(int numberOfMonths) {
        int cost;

        if (numberOfMonths < 1)
            cost = 0;
        else if (numberOfMonths >= 1 && numberOfMonths <= 2)
            cost = 100 + 400 * numberOfMonths;
        else if (numberOfMonths >= 3 && numberOfMonths <= 6)
            cost = 100 + 350 * numberOfMonths;
        else if (numberOfMonths >= 7 && numberOfMonths <= 12)
            cost = 100 + 300 * numberOfMonths;
        else
            cost = 100 + 250 * numberOfMonths;

        return cost;
    }
}
