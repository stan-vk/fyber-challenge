@IMDB
Feature: IMDB feature

  Scenario: 01 - The Top 250 page should return at least 1 movie in the list
    When IMDB top rated movies page is shown
    Then "Top Rated Movies" table should contain at least one row

  Scenario Outline: 02 - The Top 250 page should return at least 1 movie in case sorting is applied
    When IMDB top rated movies page is shown
    And user applies "<sorting>" sorting by "<item>" to "Top Rated Movies sorting control"
    Then "Top Rated Movies" table should contain at least one row
    Examples:
      | sorting    | item              |
      | ASCENDING  | Ranking           |
      | ASCENDING  | IMDb Rating       |
      | ASCENDING  | Release Date      |
      | ASCENDING  | Number of Ratings |
      | ASCENDING  | Your Rating       |
      | DESCENDING | Ranking           |
      | DESCENDING | IMDb Rating       |
      | DESCENDING | Release Date      |
      | DESCENDING | Number of Ratings |
      | DESCENDING | Your Rating       |

    Scenario: 03 - The Top 250 page should return at least 1 movie after navigating to the Western genre
      When IMDB top rated movies page is shown
      And user clicks on "Western" item of "Top Rated Movies by Genre list"
      And IMDB top rated movies by Western genre page is opened
      Then "Top Rated Movies" list should contain at least one row

