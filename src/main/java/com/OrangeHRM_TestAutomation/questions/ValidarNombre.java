package com.OrangeHRM_TestAutomation.questions;

import com.OrangeHRM_TestAutomation.userInterface.PaginaEditUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidarNombre implements Question {

    @Override
    public Boolean answeredBy(Actor actor) {


        return PaginaEditUI.USERNAME_VALIDATION.resolveFor(actor).isVisible();
    }
    public static ValidarNombre displayed(){

        return new ValidarNombre();
    }
}
