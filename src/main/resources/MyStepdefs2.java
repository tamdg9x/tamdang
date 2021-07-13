
import cucumber.Action;
import io.cucumber.datatable.DataTable;
import io.cucumber.java8.En;

import java.util.List;
import java.util.Map;

public class MyStepdefs2 implements En {
    public MyStepdefs2() {
        Given("user is login in system", () -> {
            System.out.println("Individual login to EQONEX successfully with valid username and password");
        });

        Given("Individual account is on Wallet page", () -> {
            System.out.println("User is on Wallet page");
        });

        When("Individual makes a deposit amount {currency} by {type} into account", (DataTable dataTable, String currency, String type) -> {
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
    }
}

