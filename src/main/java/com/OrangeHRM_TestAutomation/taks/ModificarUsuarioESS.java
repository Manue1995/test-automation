package com.OrangeHRM_TestAutomation.taks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.OrangeHRM_TestAutomation.userInterface.PaginaAdminUI.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;


public class ModificarUsuarioESS implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo( Click.on(ADMIN_TAB) );

        if(EDIT_BUTTON.isVisibleFor(actor)){

            actor.attemptsTo(Click.on(EDIT_BUTTON));

        }else{

            System.out.println("Usuario no se encuentra");

        }

    }

    public static ModificarUsuarioESS modificarUsuarioESS (){
        return instrumented (ModificarUsuarioESS.class);}
}
