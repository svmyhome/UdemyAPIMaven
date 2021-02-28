import io.qameta.allure.*;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;


@Epic("Работа с ЛК пользователя")
@Feature(value = "3.8 Получение справочной информации")
public class zeroTest extends ReadFileLineByLine{

    public static String idMessage;
    public static String idfield;

    @Test
//        @Step("Проверка разности числа {num1} и числа {num2}")
    @DisplayName("Получения информации о профиле {logE}")
    @Description(value = "3.8.2 Для получения информации о своём профиле используется метод GET")
    @Severity(SeverityLevel.CRITICAL)
    public void MyFirstTest() {
        given().filter(new AllureRestAssured()).log().uri().
                when().get("https://swapi.dev/api/people/1").
                then().body("name", equalTo("Luke Skywalker")).log().body().statusCode(200);
    }

    @Test
    public void SecondTest() {
        given().filter(new AllureRestAssured()).log().uri().
                when().get("https://swapi.dev/api/people/2").
                then().body("name", equalTo("C-3PO")).log().body().statusCode(200);
    }

    @Test // Валидация схемы
    public void SecondTestValidationSchema() {
        given().filter(new AllureRestAssured()).log().uri().
                when().get("https://swapi.dev/api/people/2").
                then().assertThat().body(matchesJsonSchemaInClasspath("C3PO-schema.json")).log().body();
    }

    @Test
    public void SecondTestVariable() {
        Response id1 = given().filter(new AllureRestAssured()).log().uri().
                when().get("https://swapi.dev/api/people/2").
                then().extract().response();
        System.out.println(id1.jsonPath());
    }

    @Test //ToDo Вариант извлечения переменных, если не найду лучше использовать его
    public void TherdTestVar1() {
        Response response = given().filter(new AllureRestAssured()).log().uri().
                when().get("https://swapi.dev/api/people/2").
                then().extract().response();

        idMessage = response.path("name");
       ArrayList<String> film1 = response.path("films");
        System.out.println(idMessage);
        idfield = film1.get(2);
        System.out.println(idfield);

    }

    @Test //ToDo Вариант извлечения переменных 2, если не найду лучше использовать его
    public void TherdTestVar2() {
        Response response = given().filter(new AllureRestAssured()).log().uri().
                when().get("https://swapi.dev/api/people/2").
                then().extract().response();

        String pathString = response.jsonPath().getString("name");
        List<String> film1 = response.jsonPath().get("films");
        System.out.println(pathString);
        System.out.println(film1.get(1));
    }

    @Test //ToDo Вариант использование полученного значения претти стринг
    public void TherdTestVar3() {
        String response = given().filter(new AllureRestAssured()).log().uri().
                when().get("https://swapi.dev/api/people/").
                then().extract().body().asPrettyString();
        System.out.println(response);
//        String pathString = response.jsonPath().getString("name");
//        List<String> film1 = response.jsonPath().get("films");
//        System.out.println(pathString);
//        System.out.println(film1.get(1));
    }

    @Test //ToDo Вариант использование полученного значения использования значения в том же тесте
    public void TherdTestVar5() {
        Response response = given().filter(new AllureRestAssured()).log().uri().
                when().get("https://swapi.dev/api/people/").
                then().extract().response();

        String pathString = response.jsonPath().getJsonObject("$.results[0].name");
        //String film1 = response.path("results.0").toString();

       // List<String> categories = with(Object).get("store.book.category");

        System.out.println(pathString);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(response.asPrettyString());

    }



    @Test
    public void fourTest() {
        Response response = given().filter(new AllureRestAssured()).log().uri().
                when().get("https://swapi.dev/api/people/2").
                then().extract().response();

        String jsoneResponseasString = response.jsonPath().getString("name");
        System.out.println(jsoneResponseasString);

    }

    @Test
    public void FiveTest() {
        given().filter(new AllureRestAssured()).log().uri().
                when().get("https://swapi.dev/api/people/2").
                then().body(matchesJsonSchemaInClasspath("jsonSchema.json")).log().body().statusCode(200);
    }
}
