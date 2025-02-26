package com.OrangeHRM_TestAutomation.taks;

import com.OrangeHRM_TestAutomation.utils.ExcelPrincipal;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.OrangeHRM_TestAutomation.userInterface.PaginaAdminUI.SUCCES_MESSAGE;
import static com.OrangeHRM_TestAutomation.userInterface.PaginaEditUI.DELETE_BUTTON;
import static com.OrangeHRM_TestAutomation.userInterface.PaginaEditUI.YES_DELETE_BUTTON;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class EliminarUsuario implements Task {


    public static List<Map<String,String>> leerExcel = new ArrayList<>();

    @Override
    public <T extends Actor> void performAs(T actor) {

        // Secuencia de acciones que el actor ejecutará en la interfaz de usuario

        try {
            leerExcel = ExcelPrincipal.leerDatosDeHojaDeExcel("Data1.xlsx","DatosCreacion");

        for (int i = 0; i < 2; i++) {


            actor.attemptsTo(

                    Click.on(DELETE_BUTTON.of(leerExcel.get(i).get("Validacion"))),
                    Click.on(YES_DELETE_BUTTON)

            );
        }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static EliminarUsuario eliminarUsuario (){
        return instrumented (EliminarUsuario.class);}
}
