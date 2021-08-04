package TestCases.ViaCep;

import BaseTests.ViaCep.ConsultarCepValidoBaseTest;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ConsultarCepValidoTestCase extends ConsultarCepValidoBaseTest {

    @Test
    public void ConsultarCepValido(){
        Response payload =
        given()
                .spec(requestSpec)

        .when()
                .get("https://viacep.com.br/ws/91060900/json/")
        .then()
                .spec(responseSpec)
                .log().all()
                .extract().response();

        String cep = payload.then().extract().path("cep");
        String logradouro = payload.then().extract().path("logradouro");
        String localidade = payload.then().extract().path("localidade");

        Assert.assertEquals(cep, "91060-900");
        Assert.assertEquals(logradouro, "Avenida Assis Brasil 3940");
        Assert.assertEquals(localidade, "Porto Alegre");


        payload.then().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("Schemas/ConsultaCepValidoSchema.json"));
    }
}
