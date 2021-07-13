@all_activities
Feature: Calculation

  Background:
    Given User know how to calculate sum, subtract, multiply and divide

  @scenario_outline
  Scenario Outline: User does 4 calculation sum, subtract, multiply and divide with 2 numbers
    When do the <calculation> of <numerator> and <denominator>
    Then the result matches <expected> result

    Examples:
      | calculation | numerator | denominator | expected |
      | subtract    | 3.0       | 5.0         | -2.0     |
      | divide      | 1.0       | 0.0         | Infinity |
      | sum         | 5.0       | 3.0         | 8.0      |
      | subtract    | 1.0       | -5.0        | 6.0      |
      | multiply    | -2.0      | -2.0        | 4.0      |
      | sum         | -5.0      | 7.0         | 2.0      |

