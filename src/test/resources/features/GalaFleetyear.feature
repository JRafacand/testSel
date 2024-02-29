Feature: Navigate Galavail in Fleet Section
Navigate Galavail in fleet section to view details years and months wise.

  Scenario Outline: Login as a user with the role of a fleet manager.
    Given Navigate to the login page
    When Enter user "<username>" password "<password>" environment "<environment>" and role "<role>"
    Then Search fleet Alya later Click on Availability in the Action menu
    Examples:
    | username | password | environment | role |
    | averdezoto@galavail.com | 6093Anita | 1| 1 |


  Scenario Outline: Navigate to the fleet section
      Given Selection year "<year>" and click on the active "<month>"
        Examples:
        |year| month|
        |2024| Enero, Marzo, Mayo, Julio|
        |2025| Febreo, Abril, Junio, Agosto|
        |2026| Septiembre, Octubre, Noviembre, Diciembre|





