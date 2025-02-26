package com.OrangeHRM_TestAutomation.questions;

import com.OrangeHRM_TestAutomation.userInterface.PaginaEditUI;
import com.OrangeHRM_TestAutomation.utils.ExcelPrincipal;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ValidarNombre implements Question {

    public static List<Map<String,String>> leerExcel = new ArrayList<>();

    @Override
    public Boolean answeredBy(Actor actor) {

        boolean resultado = false;

        try {

            leerExcel = ExcelPrincipal.leerDatosDeHojaDeExcel("Data1.xlsx", "DatosCreacion");

        } catch (IOException e) {

            throw new RuntimeException(e);
        }

        for (int i = 0; i < 2; i++) {

            String usuarioEliminado = leerExcel.get(i).get("Validacion"); // Extrae el usuario del Excel

            System.out.println("Se eliminó el usuario: " + usuarioEliminado); // Imprime el usuario eliminado


            resultado = PaginaEditUI.USERNAME_VALIDATION.of(usuarioEliminado).resolveFor(actor).isVisible();

        }

        return resultado;
    }

    public static ValidarNombre displayed(){

        return new ValidarNombre();
    }
}
