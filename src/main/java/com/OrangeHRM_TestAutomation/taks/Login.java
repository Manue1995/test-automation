package com.OrangeHRM_TestAutomation.taks;
import com.OrangeHRM_TestAutomation.utils.Excel;
import com.OrangeHRM_TestAutomation.utils.ExcelPrincipal;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;



import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.OrangeHRM_TestAutomation.userInterface.PaginaInicioUI.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Login implements Task {

    public static List<Map<String,String>> leerExcel = new ArrayList<>();

    Excel excel = new Excel();

    @Override
    public <T extends Actor> void performAs(T actor) {

        try {

            leerExcel = ExcelPrincipal.leerDatosDeHojaDeExcel("Data1.xlsx","DatosLogin");

            // Secuencia de acciones que el actor ejecutará en la interfaz de usuario

                actor.attemptsTo(

                        Enter.theValue(leerExcel.get(0).get("Usuario")).into(USERNAME_FIELD),
                        Enter.theValue(leerExcel.get(0).get("Clave")).into(PASSWORD_FIELD),
                        Click.on(LOGIN_BUTTON),
                        WaitUntil.the(ERROR_MESSAGE,isVisible()).forNoMoreThan(30).seconds()

                );

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static Login iniciar (){
        return instrumented (Login.class);}
}
