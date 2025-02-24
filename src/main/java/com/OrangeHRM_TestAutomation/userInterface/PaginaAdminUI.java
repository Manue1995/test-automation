package com.OrangeHRM_TestAutomation.userInterface;

import net.serenitybdd.screenplay.targets.Target;

public class PaginaAdminUI {

    public static final Target ADMIN_TAB = Target.the("Dar clic boton Admin")
            .locatedBy("nav a[href*='admin']");

    public static final Target ADD_USER_BUTTON = Target.the("Dar clic en boton añadir")
            .locatedBy("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']");

    public static final Target USER_ROLE_DROPDOWN = Target.the("Campo de Usuario Rol")
            .locatedBy("//div[@class='oxd-select-text-input' and text()='-- Select --']");

    public static final Target ADMIN_ROLE_OPTION = Target.the("Opcion  de Admin Rol")
            .locatedBy("//*[contains(text(),'Admin')]");

    public static final Target EMPLOYEE_NAME = Target.the("Nombre Empelado")
            .locatedBy("//input[contains(@placeholder,'Type for hints...')]");

    public static final Target EMPLOYEE = Target.the("Nuevo Nombre Empelado")
            .locatedBy(".//*[contains(text(),'" + "Orange  Test" + "')]");

    public static final Target STATUS_DROPDOWN = Target.the("Estatus del Usuario")
            .locatedBy("(//*[@class='oxd-select-text-input'])[2]");

    public static final Target ENABLED_OPTION = Target.the("Usuario Habilitado")
            .locatedBy("//*[contains(text(),'Enabled')]");

    public static final Target USERNAME = Target.the("Nuevo Nombre Empelado")
            .locatedBy("(//*[@class='oxd-input oxd-input--active'])[2]");

    public static final Target PASSWORD = Target.the("Ingresar la clave")
            .locatedBy("(//input[@type='password'])[1]");

    public static final Target CONFIRM_PASSWORD = Target.the("Confirmar la clave")
            .locatedBy("(//input[@type='password'])[2]");

    public static final Target SAVE_BUTTON = Target.the("Guardar")
            .locatedBy("//button[text()=' Save ']");

    public static final Target EDIT_BUTTON = Target.the("Editar Boton")
            .locatedBy("//div[contains(text(),'1Manuel1234')]/parent::div/parent::div//button//i[@class='oxd-icon bi-pencil-fill']");

    public static final Target SUCCES_MESSAGE = Target.the("Nombre de Usuarii")
            .locatedBy("//div[contains(text(),'1Manuel1234')]");

}



