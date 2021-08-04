package TestCases.ViaCep;

import BaseTests.ViaCep.ExtraBaseTest;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ExtraTestCase extends ExtraBaseTest {
    @Test
    public void ConsultarCepValido(){
        Response payload =
                given()
                        .spec(requestSpec)

                        .when()
                        .get("https://viacep.com.br/ws/94085170/json/")
                        .then()
                        .spec(responseSpec)
                        .log().all()
                        .extract().response();

        String cep = payload.then().extract().path("cep");
        String logradouro = payload.then().extract().path("logradouro");
        String localidade = payload.then().extract().path("localidade");

        Assert.assertEquals(cep, "94085-170");
        Assert.assertEquals(logradouro, "Rua Ari Barroso");
        Assert.assertEquals(localidade, "Gravataí");


        payload.then().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("Schemas/ConsultaCepValidoSchema.json"));
    }
}
