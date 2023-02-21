@db
Feature: Homework DB verification


  Scenario Outline: Verify the homework second questions's answer with DB
      Given "<month>" "<name>" "<amount> should match the DB query resultset


    Examples:



      | month    | name         | amount   |
      | February | Mike Hillyer | 4160.84  |
      | February | Jon Stephens | 4191.00  |
      | March    | Mike Hillyer | 11776.83 |
      | March    | Jon Stephens | 12109.73 |
      | April    | Mike Hillyer | 14080.36 |
      | April    | Jon Stephens | 14479.10 |
      | May      | Mike Hillyer | 234.09   |
      | May      | Jon Stephens | 280.09   |

