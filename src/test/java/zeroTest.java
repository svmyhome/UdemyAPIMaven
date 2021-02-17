import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

@Epic("Работа с ЛК пользователя")
@Feature(value = "3.8 Получение справочной информации")
public class zeroTest {


    @Test
//        @Step("Проверка разности числа {num1} и числа {num2}")
    @DisplayName("Получения информации о профиле {logE}")
    @Description(value = "3.8.2 Для получения информации о своём профиле используется метод GET")
    @Severity(SeverityLevel.CRITICAL)
    public void MyFirstTest() {
        given().log().uri().
                when().get("https://swapi.dev/api/people/1").
                then().log().body().statusCode(200);
    }

    @Test
    public void SecondTest() {
        given().log().uri().
                when().get("https://swapi.dev/api/people/2").
                then().log().body().statusCode(200);
    }
}
