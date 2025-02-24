package com.OrangeHRM_TestAutomation.questions;

import com.OrangeHRM_TestAutomation.userInterface.PaginaInicioUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class LoginValido implements Question {

    @Override
    public Boolean answeredBy(Actor actor) {

        return PaginaInicioUI.MESSAGE_DASBOARD.resolveFor(actor).isVisible();

    }
    public static LoginValido displayed(){

        return new LoginValido();
    }
}
