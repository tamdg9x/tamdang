import cucumber.Action;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en_old.Ac;
import io.cucumber.java.sl.In;
import io.cucumber.java8.En;
import org.junit.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyStepdefs implements En {
    public MyStepdefs() {
        Given("user is login in system", () -> {
            System.out.println("Individual login to EQONEX successfully with valid username and password");
        });

        Given("Individual account is on Wallet page", () -> {
            System.out.println("User is on Wallet page");
        });

        When("Individual makes a deposit {double} currency by type into account", (Double amount, DataTable dataTable) -> {
            Boolean isNegativeNumber = Action.isNegativeNumber(amount);
            List<Map<String, String>> data = dataTable.asMaps();
            if (isNegativeNumber) {
                System.out.println("Can't deposit with negative or zero amount");
            }
            else
            {
                for (Map<String, String> deposit_ccy : data)
                {
                    System.out.println("You can deposit " + amount + " " + deposit_ccy.get("currency") + " by " + deposit_ccy.get("type"));
                }

            }
        });

        Then("Individual's balance is increased with the corresponding deposit {double}", (Double amount) -> {
            String message = Action.depositStatus(amount);
            System.out.println(message);
        });


        Given("User know how to calculate sum, subtract, multiply and divide", () -> {
            System.out.println("Who is more intelligent than a 5th grade?");
        });

//        Given ("user enter 2 numbers a and b", () -> {
//            System.out.println("Calculate + - * / of 2 numbers: ");
//        });

//        When("do the {word} of {} and {}", (String calculation, Float a, Float b) -> {
//            Float result = Action.doCalculation(calculation, a, b);
//            Map<String, Object> mapResult = new HashMap<>();
//            mapResult.put("result", result);
//            Global.testContext.set(mapResult);
//            System.out.println("The " + calculation + " of " + a + " and " + b + " is " + result);
//        });


        When("do the {word} of {} and {}", (String calculation, Float numerator, Float denominator) -> {
            Boolean isDivideToZero = Action.divideToZero(denominator);
            if (isDivideToZero)
            {
                System.out.println("Denominator is zero");
            }
            else
            {
                System.out.println("Good to go");
                Float actualResult = Action.doCalculation(calculation, numerator, denominator);
                Map<String, Object> mapResult = new HashMap<>();
                mapResult.put("result", actualResult);
                Global.testContext.set(mapResult);
                System.out.println("The " + calculation + " of " + numerator + " and " + denominator + " is " + actualResult);
            }

        });

        Then ("the result matches {} result", (Float expected) -> {
            if (Global.testContext.get().get("result") == )
            {
                System.out.println("Can't divide to zero");
            }
            else
            {
                Assert.assertEquals(Global.testContext.get().get("result"), expected);
                System.out.println("Actual matches expected result");
                System.out.println("\n----------------------\n\n");
            }
        });

    }
}
