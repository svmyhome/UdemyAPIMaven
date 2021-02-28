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

    @Test
    public void POSTJSON(){
        String jsonBody = "{\n" +
                "\"userId\":1,\n" +
                "\"id\":1,\n" +
                "\"title\":\"sunt aut facere repellat provident occaecati excepturi optio reprehenderit\",\n" +
                "\"body\":\"quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto\"\n" +
                "}";

        given().filter(new AllureRestAssured()).body(jsonBody).log().uri().
                when().post("https://jsonplaceholder.typicode.com/posts").
                then().log().body().statusCode(201);
    }

    @Test
    public void POSTXML() {
        String xmlBoby = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                "    <soap:Body>\n" +
                "        <SubmitAuth xmlns=\"urn:cbr-ru:nfosoap:v1.1\">\n" +
                "            <name>OCUD0420406_31.12.2020.zip.enc</name>\n" +
                "            <taskName>{{TaskName_0}}</taskName>\n" +
                "            <body>{{Body_0}}</body>        \n" +
                "        </SubmitAuth>\n" +
                "    </soap:Body>\n" +
                "</soap:Envelope>";

        given().filter(new AllureRestAssured()).body(xmlBoby).log().uri().
                when().post("https://enocxr5j4gbq.x.pipedream.net").
                then().log().body().statusCode(200);
    }

}
