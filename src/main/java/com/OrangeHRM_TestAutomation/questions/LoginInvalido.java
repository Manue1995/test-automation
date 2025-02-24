package com.OrangeHRM_TestAutomation.questions;

import com.OrangeHRM_TestAutomation.userInterface.PaginaInicioUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class LoginInvalido implements Question <Boolean>{

    @Override
    public Boolean answeredBy(Actor actor) {

        return PaginaInicioUI.REQUIRED_MESSAGE_USERNAME.resolveFor(actor).isVisible();
    }
    public static LoginInvalido displayed(){

        return new LoginInvalido();
    }
}
