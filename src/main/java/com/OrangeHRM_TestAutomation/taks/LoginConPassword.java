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
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class LoginConPassword implements Task {

    public static List<Map<String,String>> leerExcel = new ArrayList<>();

    Excel excel = new Excel();

    @Override
    public <T extends Actor> void performAs(T actor) {


        try {
            leerExcel = ExcelPrincipal.leerDatosDeHojaDeExcel("Data1.xlsx","DatosLogin");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        actor.attemptsTo(

                WaitUntil.the(PASSWORD_FIELD,isVisible()).forNoMoreThan(30).seconds(),
                Enter.theValue(leerExcel.get(1).get("Clave")).into(PASSWORD_FIELD),
                Click.on(LOGIN_BUTTON),
                WaitUntil.the(REQUIRED_MESSAGE_USERNAME,isVisible()).forNoMoreThan(30).seconds()
        );

    }

    public static LoginConPassword iniciarPass (){
        return instrumented (LoginConPassword.class);}
}
