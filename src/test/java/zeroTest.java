import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class zeroTest {

    @Test
    public void MyFirstTest() {
        given().log().uri().
                when().get("https://swapi.dev/api/people/1").
                then().log().body().statusCode(200);
    }

    @Test
    public void SecondTest() {
        given().log().uri().
                when().get("https://swapi.dev/api/people/2").
                then().log().body().statusCode(201);
    }
}
