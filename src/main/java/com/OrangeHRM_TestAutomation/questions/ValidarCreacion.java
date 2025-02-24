package com.OrangeHRM_TestAutomation.questions;

import com.OrangeHRM_TestAutomation.userInterface.PaginaAdminUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidarCreacion implements Question {

    @Override
    public Object answeredBy(Actor actor) {

        return PaginaAdminUI.SUCCES_MESSAGE.resolveFor(actor).isVisible();
    }

    public static ValidarCreacion displayed(){

        return new ValidarCreacion();
    }
}
