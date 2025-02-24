package com.OrangeHRM_TestAutomation.questions;

import com.OrangeHRM_TestAutomation.userInterface.PaginaEditUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidarRol implements Question {

    @Override
    public Boolean answeredBy(Actor actor) {


        return PaginaEditUI.ESS_VALIDATION.resolveFor(actor).isVisible();
    }

    public static ValidarRol displayed(){

        return new ValidarRol();
    }
}
