package com.OrangeHRM_TestAutomation.taks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.OrangeHRM_TestAutomation.userInterface.PaginaAdminUI.EDIT_BUTTON;
import static com.OrangeHRM_TestAutomation.userInterface.PaginaInicioUI.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class LoginNull implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {

        if(LOGIN_BUTTON.isVisibleFor(actor)){

            actor.attemptsTo(

                    Click.on(LOGIN_BUTTON),
                    WaitUntil.the(REQUIRED_MESSAGE_PASSWORD,isVisible()).forNoMoreThan(30).seconds());

        }else {

            System.out.println("El boton de login no se encuentra visible");
        }


    }
    public static LoginNull loginNull (){
        return instrumented (LoginNull.class);}
}
