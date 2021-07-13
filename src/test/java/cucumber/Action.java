package cucumber;

public class Action {
    public Action() {
    }

    public static Boolean isNegativeNumber(Double amount) {
        if (amount == 0 || amount < 0) {
            return true;
        } else return false;
    }

    public static String depositStatus(Double amount) {
        if (amount == 0 || amount < 0) {
            return "Fail to deposit \n--------------\n\n";
        } else return "Deposit successfully " + amount + " of each currency into account \n--------------\n\n";
    }

    public static float doCalculation(String calculation, float a, float b) {
        if (calculation.equals("sum")) {
            return a + b;
        } else if (calculation.equals("subtract")) {
            return a - (b);
        } else if (calculation.equals("multiply")) {
            return a * b;
        } else { return a / b; }

        }

    public static Boolean divideToZero(Float denominator) {
        if (denominator == 0)
        {
            return true;
        }
        else return false;
    }
}


