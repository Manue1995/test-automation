package com.OrangeHRM_TestAutomation.questions;

import com.OrangeHRM_TestAutomation.userInterface.PaginaInicioUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;


public class LoginVacio implements Question {

    @Override
    public Boolean answeredBy(Actor actor) {

        boolean required1 = PaginaInicioUI.REQUIRED_MESSAGE_PASSWORD.resolveFor(actor).isVisible();

        boolean required = PaginaInicioUI.REQUIRED_MESSAGE_USERNAME.resolveFor(actor).isVisible();


        return required1 && required;

    }
    public static LoginVacio displayed(){

        return new LoginVacio();
    }
}
