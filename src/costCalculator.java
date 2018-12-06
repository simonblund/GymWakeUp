<<<<<<< HEAD
public class CostCalculator{

    private int cost;

    public int calculate(int numberOfMonths){
=======
public class costCalculator{
    
    public static int calculate(int numberOfMonths){
        int cost;
>>>>>>> b30ee4c6940ece35c9c85abc32ee3288856ae674

        if (numberOfMonths < 1)
            cost =0;
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
