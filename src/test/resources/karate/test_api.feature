Feature: Validate api test

  yo como para .. recordar la sintais bdd gherkii

  Scenario: validar get de api chuck norris random  Respuesta exitosa
    Given url 'https://api.chucknorris.io/jokes/random'
    When method get
    Then  status 200
    And match response != 'error!
    And match response contains { id: #notnull }

