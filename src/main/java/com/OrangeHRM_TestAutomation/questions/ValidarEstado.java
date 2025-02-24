package com.OrangeHRM_TestAutomation.questions;


import com.OrangeHRM_TestAutomation.userInterface.PaginaEditUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidarEstado implements Question {


    @Override
    public Boolean answeredBy(Actor actor) {


        return PaginaEditUI.DISABLE_VALIDATION.resolveFor(actor).isVisible();
    }
    public static ValidarEstado displayed(){

        return new ValidarEstado();
    }
}

