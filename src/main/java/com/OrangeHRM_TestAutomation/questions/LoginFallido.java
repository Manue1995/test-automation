package com.OrangeHRM_TestAutomation.questions;

import com.OrangeHRM_TestAutomation.userInterface.PaginaInicioUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class LoginFallido implements Question {

    @Override
    public Boolean answeredBy(Actor actor) {

        return PaginaInicioUI.ERROR_MESSAGE.resolveFor(actor).isVisible();
    }
    public static LoginFallido displayed(){

        return new LoginFallido();
    }
}
