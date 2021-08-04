package TestCases.ViaCep;

import BaseTests.ViaCep.ConsultarCepInexistenteBaseTest;
import io.restassured.matcher.RestAssuredMatchers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ConsultarCepInexistenteTestCase extends ConsultarCepInexistenteBaseTest {

    @Test
    public void ConsultarCepInexistente() {
            Response payload =
            given()
                    .spec(requestSpec)
            .when()
                    .get("https://viacep.com.br/ws/01234567/json/")
            .then()
                    .spec(responseSpec)
                    .log().all()
                    .extract().response();

    }
}
