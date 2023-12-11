package modules.users;

import config.PathConfig;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
import pojo.UserPojo;
import utils.UserDefinition;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;


@DisplayName("Testes de API Rest request Create")
public class CreateTest extends PathConfig {

    UserPojo user;
    @BeforeEach
    public void beforeEach () {
        user = new UserDefinition().fillUser();
    }
    @Test
    @DisplayName("Validar que o post Create retorna statuscode 201 e o contrato corresponde ao esperado em documentação")
    public void testCreatePost() {
        given()
                .contentType(ContentType.JSON)
                .body(user)
        .when()
                .post(path+"/users")

        .then()
                .assertThat()
                .contentType(ContentType.JSON)
                .statusCode(HttpStatus.SC_CREATED)
                .body(matchesJsonSchemaInClasspath("Schema/CreatePost.json"))
                .log()
                .all();
    }
}
