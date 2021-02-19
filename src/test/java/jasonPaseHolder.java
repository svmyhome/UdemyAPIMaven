import io.qameta.allure.restassured.AllureRestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class jasonPaseHolder {

    @Test
    public void GET(){
        given().filter(new AllureRestAssured()).queryParam("postId", "1").log().uri().
                when().get("https://jsonplaceholder.typicode.com/comments").
                then().log().body().statusCode(201);
    }

    @Test
    public void PUT(){
        String jsonBody = "{\n" +
                "\"userId\":1,\n" +
                "\"id\":1,\n" +
                "\"title\":\"sunt aut facere repellat provident occaecati excepturi optio reprehenderit\",\n" +
                "\"body\":\"quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto\"\n" +
                "}";
        given().filter(new AllureRestAssured()).body(jsonBody).log().uri().
                when().put("https://jsonplaceholder.typicode.com/posts/1").
                then().log().body().statusCode(200);
    }

    @Test
    public void DELETE(){
        given().filter(new AllureRestAssured()).log().uri().
                when().delete("https://jsonplaceholder.typicode.com/posts/1").
                then().log().body().statusCode(200);
    }

}
