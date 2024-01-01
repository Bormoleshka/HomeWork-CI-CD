package org.max.lesson3.home.accuweather;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.max.lesson3.home.accuweather.location.Location;

import java.util.List;

import static io.restassured.RestAssured.given;
@Epic(value = "Тестирование API http://dataservice.accuweather.com")
@Feature(value = "Домашняя Работа 6")

public class GetLocationTest extends AccuweatherAbstractTest{

    @Test
    @Owner("Алексей Бормотов")

    @Severity(SeverityLevel.NORMAL)
    @DisplayName("тест на проверку запроса по геопозиции")
    void getLocation_search_returnMoscow() {

        List<Location> response = given()
                .queryParam("apikey", getApiKey())
                .queryParam("q", "Moscow")
                .when()
                .get(getBaseUrl()+"/locations/v1/cities/search")
                .then()
                .statusCode(200)
                .time(Matchers.lessThan(2000l))
                .extract()
                .body().jsonPath().getList(".", Location.class);

        Assertions.assertEquals(24,response.size());
        Assertions.assertEquals("Moscow", response.get(0).getEnglishName());
    }
}
