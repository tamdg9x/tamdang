@all_activities
  Feature: Activities
    Background:
      Given user is login in system

    @scenario_outline
    Scenario Outline: as Individual is on Wallet page, Individual makes a deposit request, then user's balance is up
      Given Individual account is on Wallet page
      When Individual makes a deposit <double> currency by type into account
      | currency | type   |
      | BTC      | crypto |
      | EQO      | crypto |
      | ETH      | crypto |
      | USD      | fiat   |
      Then Individual's balance is increased with the corresponding deposit <double>

      Examples:
        | double |
        | 0      |
        | -100   |
        | 0.01   |
        | 10000  |