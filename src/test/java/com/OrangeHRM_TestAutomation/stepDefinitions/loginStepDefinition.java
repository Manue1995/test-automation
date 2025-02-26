package com.OrangeHRM_TestAutomation.stepDefinitions;

import com.OrangeHRM_TestAutomation.questions.LoginInvalido;
import com.OrangeHRM_TestAutomation.questions.LoginFallido;
import com.OrangeHRM_TestAutomation.questions.LoginVacio;
import com.OrangeHRM_TestAutomation.questions.LoginValido;
import com.OrangeHRM_TestAutomation.taks.Login;
import com.OrangeHRM_TestAutomation.taks.LoginConPassword;
import com.OrangeHRM_TestAutomation.taks.LoginExitoso;
import com.OrangeHRM_TestAutomation.taks.LoginNull;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;


public class loginStepDefinition {

    @Managed(driver = "chrome")

    private WebDriver navegador;
    private Actor manuel = Actor.named("manuel");

    @Before

    public void configuracion (){

        manuel.can(BrowseTheWeb.with(navegador));

    }

    @Given("el usuario está en la página de login")
    public void elUsuarioEstáEnLaPáginaDeLogin() {

        manuel.wasAbleTo(Open.url("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"));

    }
    @When("ingresa {string} y {string}")
    public void ingresaY(String string, String string2) {

        manuel.attemptsTo(Login.iniciar());

    }

    @When("no ingresa el usuario y coloca la contraseña {string}")
    public void noIngresaElUsuarioYColocaLaContraseña(String string) {

        manuel.attemptsTo(LoginConPassword.iniciarPass());
    }

    @When("no ingresa usuario ni contraseña")
    public void noIngresaUsuarioNiContraseña() {

        manuel.attemptsTo(LoginNull.loginNull());
    }

    @When("el usuario ingresa credenciales validas")
    public void elUsuarioIngresaCredencialesValidas() {

        manuel.attemptsTo(LoginExitoso.loginExitoso());
    }

    @Then("debería ver el mensaje {string}")
    public void deberíaVerElMensajeBienvenido(String string) {

        //Crea un diccionario que evalua preguntas de un elemento visible
        Map<Question<Boolean>, String> mensajes = Map.of (

                LoginFallido.displayed(), "Login Fallido: Credenciales Invalidas",
                LoginInvalido.displayed(), "Login Fallido: Falta Usuario",
                LoginVacio.displayed(), "Login Fallido: Falta Usuario y Contraseña",
                LoginValido.displayed(), "Login Exitoso: Credenciales correctas"

         );

        //Recorre el map buscando la primera condicion que se cumpla

        for (var entry : mensajes.entrySet()) {  //Representa cada iteracion  del bucle

            if (entry.getKey().answeredBy(manuel)) { //Obtener la clave de la Question

                manuel.should(seeThat(entry.getKey(), equalTo(true)));
                System.out.println(entry.getValue());

                return;
            }
        }

        throw new AssertionError("No se pudo determinar el resultado del login.");
    }

}
