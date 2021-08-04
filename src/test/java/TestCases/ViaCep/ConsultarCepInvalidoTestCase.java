package TestCases.ViaCep;

import BaseTests.ViaCep.ConsultarCepInvalidoBaseTest;
import BaseTests.ViaCep.ConsultarCepValidoBaseTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class ConsultarCepInvalidoTestCase extends ConsultarCepInvalidoBaseTest {

    @Test
    public void ConsultarCepInvalidoTestCase() {

            Response payload =
                    given()
                            .spec(requestSpec)
                            .when()
                            .get("https://viacep.com.br/ws/1234567/json/")
                            .then()
                            .spec(responseSpec)
                            .log().all()
                            .extract().response();

                   }

    }

