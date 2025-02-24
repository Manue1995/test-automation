package com.OrangeHRM_TestAutomation.questions;

import com.OrangeHRM_TestAutomation.userInterface.PaginaInicioUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;


public class LoginVacio implements Question {

    @Override
    public Boolean answeredBy(Actor actor) {

        return PaginaInicioUI.REQUIRED_MESSAGE_PASSWORD.resolveFor(actor).isVisible();

    }
    public static LoginVacio displayed(){

        return new LoginVacio();
    }
}
