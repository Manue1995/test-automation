package com.OrangeHRM_TestAutomation.taks;

import com.OrangeHRM_TestAutomation.utils.ExcelPrincipal;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.BackendTask;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.OrangeHRM_TestAutomation.userInterface.PaginaAdminUI.*;
import static com.OrangeHRM_TestAutomation.userInterface.PaginaEditUI.*;
import static com.OrangeHRM_TestAutomation.userInterface.PaginaInicioUI.ERROR_MESSAGE;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class EditarUsuario implements Task {

    public static List<Map<String,String>> leerExcel = new ArrayList<>();

    @Override
    public <T extends Actor> void performAs(T actor) {


        try {


        leerExcel = ExcelPrincipal.leerDatosDeHojaDeExcel("Data1.xlsx","DatosCreacion");

        actor.attemptsTo(

                Click.on(USER_ROLE_ESS),
                Click.on(ESS_ROLE_OPTION),Click.on(STATUS_DROPDOWN),
                Click.on(DISABLE_OPTION),
                DoubleClick.on(USERNAME),
                Hit.the(Keys.DELETE).into(CLEAR_FIELD),
                Enter.theValue(leerExcel.get(1).get("Username")).into(NEW_USERNAME),
                SetCheckbox.of(CHECKBOX).toTrue(),
                Enter.theValue(leerExcel.get(1).get("Password")).into(PASSWORD),
                Enter.theValue(leerExcel.get(1).get("Password")).into(CONFIRM_PASSWORD),
                Click.on(SAVE_BUTTON),
                WaitUntil.the(USERNAME_VALIDATION,isVisible()).forNoMoreThan(30).seconds()

            );

         } catch (
            IOException e) {
               throw new RuntimeException(e);
         }


    }

    public static EditarUsuario editarUsuario (){
        return instrumented (EditarUsuario.class);}
}
