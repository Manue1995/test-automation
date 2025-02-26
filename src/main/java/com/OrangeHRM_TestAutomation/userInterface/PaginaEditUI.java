package com.OrangeHRM_TestAutomation.userInterface;

import net.serenitybdd.screenplay.targets.Target;

public class PaginaEditUI {


    public static final Target USER_ROLE_ESS = Target.the("Seleccionar Cambio de Rol")
            .locatedBy("//div[@class='oxd-select-text-input' and text()='Admin']");

    public static final Target ESS_ROLE_OPTION = Target.the("Cambio de Rol")
            .locatedBy("//*[contains(text(),'ESS')]");

    public static final Target DISABLE_OPTION = Target.the("Cambio de Rol")
            .locatedBy("//*[contains(text(),'Disabled')]");

    public static final Target CHECKBOX = Target.the("CheckBox")
            .locatedBy("//*[@class='oxd-icon bi-check oxd-checkbox-input-icon']");

    public static final Target DISABLE_VALIDATION = Target.the("Validar estado")
            .locatedBy("//div[contains(text(),'1Andres1234')]/parent::div/parent::div//*[contains(text(),'Disabled')]");

    public static final Target ESS_VALIDATION = Target.the("Validar estado")
            .locatedBy("//div[contains(text(),'1Andres1234')]/parent::div/parent::div//*[contains(text(),'ESS')]");

    public static final Target USERNAME_VALIDATION = Target.the("Validar estado")
            .locatedBy("//div[text()='{0}']");

    public static final Target DELETE_BUTTON = Target.the("Eliminar Registro")
            .locatedBy("//div[contains(text(),'{0}')]/parent::div/parent::div//button//i[@class='oxd-icon bi-trash']");

    public static final Target YES_DELETE_BUTTON = Target.the("Eliminar Registro")
            .locatedBy("//button/i[@class='oxd-icon bi-trash oxd-button-icon']");

    public static final Target CLEAR_FIELD = Target.the("Limpiar Nombre")
            .locatedBy("div.oxd-form-row input.oxd-input");

    public static final Target NEW_USERNAME = Target.the("Ingresar Nuevo Usuario")
            .locatedBy("form div.oxd-form-row input.oxd-input");

}
