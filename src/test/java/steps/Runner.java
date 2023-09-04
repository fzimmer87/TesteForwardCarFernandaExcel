package org.example;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {
                "C:\\ProjetosBN\\Projetos individuais\\ProjetoGrupo\\ApiFernandaeEdson\\TesteForwardCarFernandaeEdson\\src\\test\\java\\Feature\\ForwardCar.feature",
        },
        glue = {
                "org/example"
        },
        tags = "@CT001"

)
public class Runner {
}
