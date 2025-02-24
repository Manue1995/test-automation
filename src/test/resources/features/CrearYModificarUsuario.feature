Feature: Creación y Modificación de Usuario en OrangeHRM

  Background: Crear usuario Admin y modificarlo

    Given el usuario está en la página de login
    When el usuario ingresa credenciales validas

  @Test1
  Scenario: 1 - Crear un nuevo usuario con rol Admin

    When hace click en la pestaña "Admin" e ingresa los campos solicitados
    Then el sistema debería mostrar un mensaje confirmando la creación del usuario

  @Test2
  Scenario: 2 - Modificar usuario creado

    Given el usuario ha creado un usuario con username "1<Nombre>1234"
    When realiza los cambios solicitados
    Then el sistema debería mostrar un mensaje confirmando la modificación del usuario

