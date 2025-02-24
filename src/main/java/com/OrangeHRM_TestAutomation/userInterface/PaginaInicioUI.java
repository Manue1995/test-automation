package com.OrangeHRM_TestAutomation.userInterface;


import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PaginaInicioUI {

public static final Target USERNAME_FIELD = Target.the("Ingresar Nombre de Usuario")
        .located(By.name("username"));

public static final Target PASSWORD_FIELD = Target.the("Ingresar Clave")
        .located(By.name("password"));

public static final Target LOGIN_BUTTON = Target.the("Boton de Login")
        .locatedBy("//button[@type='submit']");

public static final Target  ERROR_MESSAGE = Target.the("Mensaje de Credenciales Invalidas")
        .locatedBy("//p[contains(@class, 'oxd-alert-content-text')]");

public static final Target REQUIRED_MESSAGE_USERNAME = Target.the("Mensaje de Usuario Requerido")
        .locatedBy("(//span[text()='Required'])[1]");

public static final Target REQUIRED_MESSAGE_PASSWORD = Target.the("Mensaje de Contraseña Requerido")
        .locatedBy("(//span[text()='Required'])[2]");

public static final Target MESSAGE_DASBOARD = Target.the("Mensaje de Login Exitoso")
        .locatedBy("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span");




}
