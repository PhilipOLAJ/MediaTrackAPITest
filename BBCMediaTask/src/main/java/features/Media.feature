Feature: Automate the GET endpoint
  Scenario: create a booking
    When i do a get request for media
    Then status code is returned
    And response time of the request is below 1000 milliseconds

  Scenario: verify ID is not null and segment type field has music
    When I do a get request for media
    Then verify ID field is not null in all the tracks
      And  Segment type field has music as value

    Scenario: Verify the primary field in title_list is never null
      Then primary field in title_list is never null

      Scenario: Verify that only one track in the list has “now_playing” field in “offset” as true
        Then only one track in the list has “now_playing” field in “offset” as true