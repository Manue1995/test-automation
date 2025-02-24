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
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;


public class loginStepDefinition {

    @Managed(driver = "chrome")

    private WebDriver navegador;
    private Actor manuel = Actor.named("manuel");

    @Before

    public void configuracion (){

        manuel.can(BrowseTheWeb.with(navegador));

         //navegador = new ChromeDriver();  // Configura el driver
        //navegador.manage().window().maximize();
        //manuel.can(BrowseTheWeb.with(navegador));

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

        if(LoginFallido.displayed().answeredBy(manuel)){

            System.out.println("Login Fallido: Credenciales Invalidas");
            manuel.should(seeThat(LoginFallido.displayed(),equalTo(true)));

        }else if (LoginInvalido.displayed().answeredBy(manuel)) {

            System.out.println("Login Fallido: Falta Usuario o Contraseña");
            manuel.should(seeThat(LoginInvalido.displayed(), equalTo(true)));

        }else if (LoginVacio.displayed().answeredBy(manuel)) {

            manuel.should(seeThat(LoginVacio.displayed(), equalTo(true)));
            manuel.should(seeThat(LoginInvalido.displayed(), equalTo(true)));

        } else if (LoginValido.displayed().answeredBy(manuel)) {

            System.out.println("Login Exitoso: Credenciales correctas");

            manuel.should(seeThat(LoginValido.displayed(),equalTo(true)));

        }else {

            throw new AssertionError("No se pudo determinar el resultado del login.");
        }
    }

}
