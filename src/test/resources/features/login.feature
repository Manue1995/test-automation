Feature: Validación de Login


  Background: Validar inicio de sesion con credenciales validas e invalidas

    Given el usuario está en la página de login

   @Test1
  Scenario: 1 - Intento de login con credenciales incorrectas

    When ingresa "usuarioIncorrecto" y "claveIncorrecta"
    Then debería ver el mensaje "Invalid credentials"

   @Test2
  Scenario: 2 - Intento de login sin ingresar el Username

    When no ingresa el usuario y coloca la contraseña "admin123"
    Then debería ver el mensaje "Required"

   @Test3
  Scenario: 3 - Intento de login con campos vacíos

    When no ingresa usuario ni contraseña
    Then debería ver el mensaje "Required"

   @Test4
  Scenario: 4 - Login Exitoso

     When el usuario ingresa credenciales validas
     Then debería ver el mensaje "Bienvenido"

