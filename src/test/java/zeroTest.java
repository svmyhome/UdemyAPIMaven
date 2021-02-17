import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class zeroTest {

    @Test
    public void MyFirstTest() {
        given().
                when().get("https://swapi.dev/api/people/1").
                then().statusCode(200);
    }
}
