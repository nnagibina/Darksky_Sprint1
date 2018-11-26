Feature: Testing Home webpage of "https://darksky.net"

  @darksky_search_temperature
  Scenario: Search for the current temperature of the region and comparison with the range of low and high values
    Given Goto
    When Clear search text field
    And Enter address or zipcode into the search field "07432"
    And Click on search magnifying glass
    Then Verify current temperature is between low and high value

  @darksky_verify_temp_timeline
  Scenario: Verify timline is displayed in correct format
    Given I am on Darksky home page
    Then I verify timeline is displayed with two hours incremented

  @darksky_verify_lowest_and_highest_temp
  Scenario: Verify individual day temp timeline
    Given I am on Darksky home Page
    When I expand todays timeline
    Then I verify lowest and highest temp is displayed correctly