package com.OrangeHRM_TestAutomation.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/CrearYModificarUsuario.feature",
        //tags = "@Test2",
        glue = "com/OrangeHRM_TestAutomation/stepDefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE)


public class CrearYModicarUsuarioRunner {
}
