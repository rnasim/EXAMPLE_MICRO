Feature: Validate Amazon search

  Scenario Outline: Validate Amazon search
    Given user visit amazon homepage
    When user type "<productname>" and click search icon 
    Then user should able to see the expected product

    Examples: 
      | productname  | 
      | iphone 12 promax | 
      #passing the product name as argument in the when method
      