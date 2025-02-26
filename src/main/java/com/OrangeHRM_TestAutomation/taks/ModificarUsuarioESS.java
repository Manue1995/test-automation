package com.OrangeHRM_TestAutomation.taks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.OrangeHRM_TestAutomation.userInterface.PaginaAdminUI.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;


public class ModificarUsuarioESS implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {


            // Secuencia de acciones que el actor ejecutará en la interfaz de usuario

                actor.attemptsTo(Click.on(ADMIN_TAB));


    }

    public static ModificarUsuarioESS modificarUsuarioESS (){
        return instrumented (ModificarUsuarioESS.class);}
}
