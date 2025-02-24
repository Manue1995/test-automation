package com.OrangeHRM_TestAutomation.stepDefinitions;

import com.OrangeHRM_TestAutomation.questions.*;
import com.OrangeHRM_TestAutomation.taks.CrearUsuarioAdmin;
import com.OrangeHRM_TestAutomation.taks.EditarUsuario;
import com.OrangeHRM_TestAutomation.taks.EliminarUsuario;
import com.OrangeHRM_TestAutomation.taks.ModificarUsuarioESS;
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

public class CrearYModificarUsuarioStepDefinition {

    @Managed(driver = "chrome")

    private WebDriver navegador;
    private Actor manuel = Actor.named("manuel");

    @Before
    public void configuracion (){

        manuel.can(BrowseTheWeb.with(navegador));

    }

    @When("hace click en la pestaña {string} e ingresa los campos solicitados")
    public void haceClickEnLaPestaña(String string) {

        manuel.attemptsTo(CrearUsuarioAdmin.crearUsuarioAdmin());

    }

    @Given("el usuario ha creado un usuario con username {string}")
    public void elUsuarioHaCreadoUnUsuarioConUsername(String string) {

        manuel.attemptsTo(ModificarUsuarioESS.modificarUsuarioESS());

    }
    @When("realiza los cambios solicitados")
    public void realizaLosCambiosSolicitados() {


        manuel.attemptsTo(EditarUsuario.editarUsuario());
       // manuel.attemptsTo(EliminarUsuario.eliminarUsuario());

    }

    @Then("el sistema debería mostrar un mensaje confirmando la modificación del usuario")
    public void elSistemaDeberíaMostrarUnMensajeConfirmandoLaModificaciónDelUsuario() {

        if(ValidarNombre.displayed().answeredBy(manuel)){
            if (ValidarRol.displayed().answeredBy(manuel)){
                if (ValidarEstado.displayed().answeredBy(manuel)){

                    System.out.println("Validacion correcta de cambios");

                }else{
                        System.out.println("Error en validacion" );
                }
            }else {
                System.out.println("Validacion de Nombre y Rol");
            }
        }else {
            System.out.println("Error");

        }

        manuel.attemptsTo(EliminarUsuario.eliminarUsuario());
        manuel.should(seeThat(ValidarNombre.displayed(),equalTo(false)));
        System.out.println("Usuario Eliminado");

    }

    @Then("el sistema debería mostrar un mensaje confirmando la creación del usuario")
    public void elSistemaDeberíaMostrarUnMensajeConfirmandoLaCreaciónDelUsuario() {

        manuel.should(seeThat(ValidarCreacion.displayed(),equalTo(true)));
        System.out.println("Creacion Exitosa");


    }
}
