package com.OrangeHRM_TestAutomation.taks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.OrangeHRM_TestAutomation.userInterface.PaginaInicioUI.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class LoginNull implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(

                Click.on(LOGIN_BUTTON),
               // WaitUntil.the(REQUIRED_MESSAGE_USERNAME,isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(REQUIRED_MESSAGE_PASSWORD,isVisible()).forNoMoreThan(30).seconds()
        );


    }
    public static LoginNull loginNull (){
        return instrumented (LoginNull.class);}
}
