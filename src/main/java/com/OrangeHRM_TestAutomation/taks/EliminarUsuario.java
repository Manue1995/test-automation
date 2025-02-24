package com.OrangeHRM_TestAutomation.taks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.OrangeHRM_TestAutomation.userInterface.PaginaAdminUI.SUCCES_MESSAGE;
import static com.OrangeHRM_TestAutomation.userInterface.PaginaEditUI.DELETE_BUTTON;
import static com.OrangeHRM_TestAutomation.userInterface.PaginaEditUI.YES_DELETE_BUTTON;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class EliminarUsuario implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(

                Click.on(DELETE_BUTTON),
                Click.on(YES_DELETE_BUTTON)

        );

    }

    public static EliminarUsuario eliminarUsuario (){
        return instrumented (EliminarUsuario.class);}
}
