package com.OrangeHRM_TestAutomation.taks;

import com.OrangeHRM_TestAutomation.utils.ExcelPrincipal;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.webdriver.javascript.JavascriptExecutorFacade;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
//import net.serenitybdd.screenplay.ensure.Ensure;




import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.OrangeHRM_TestAutomation.userInterface.PaginaAdminUI.*;
import static com.OrangeHRM_TestAutomation.userInterface.PaginaInicioUI.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CrearUsuarioAdmin implements Task {


    public static List<Map<String,String>> leerExcel = new ArrayList<>();

    @Override
    public <T extends Actor> void performAs(T actor) {


        try {

            leerExcel = ExcelPrincipal.leerDatosDeHojaDeExcel("Data1.xlsx","DatosCreacion");

        actor.attemptsTo(

                    WaitUntil.the(ADMIN_TAB,isVisible()).forNoMoreThan(10).seconds(),
                    Click.on(ADMIN_TAB),
                    Click.on(ADD_USER_BUTTON),
                    Click.on(USER_ROLE_DROPDOWN),
                    Click.on(ADMIN_ROLE_OPTION),
                    Enter.theValue(leerExcel.get(0).get("EmployeeName")).into(EMPLOYEE_NAME),
                    Click.on(EMPLOYEE),
                    Click.on(STATUS_DROPDOWN),Click.on(ENABLED_OPTION),
                    Enter.theValue(leerExcel.get(0).get("Username")).into(USERNAME),
                    Enter.theValue(leerExcel.get(0).get("Password")).into(PASSWORD),
                    Enter.theValue(leerExcel.get(0).get("Password")).into(CONFIRM_PASSWORD),
                    Click.on(SAVE_BUTTON),

                    //Validar la creacion del usuario
                    // Click.on(ADMIN_TAB),
                     WaitUntil.the(SUCCES_MESSAGE,isVisible()).forNoMoreThan(30).seconds()

            );

        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }

    public static CrearUsuarioAdmin crearUsuarioAdmin (){
        return instrumented (CrearUsuarioAdmin.class);}

}
