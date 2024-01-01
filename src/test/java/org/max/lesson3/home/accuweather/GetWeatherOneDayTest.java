import io.restassured.http.Method;

import io.qameta.allure.*;

import org.hamcrest.Matchers;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;

import seminar.accuweather.location.Location;

import seminar.accuweather.weather.Weather;



import java.util.HashMap;

import java.util.List;

import java.util.Map;



import static io.restassured.RestAssured.given;

import static org.hamcrest.Matchers.lessThan;
@Epic(value = "Тестирование API https://developer.accuweather.com/accuweather-forecast-api/apis")

@Feature(value = "Домашняя работа 6")

public class GetWeatherOneDayTest extends AccuweatherAbstractTest {

    @Test


    @Link("http://dataservice.accuweather.com/forecasts/v1/daily/10day/{locationKey}")

    @Owner("Алексей Бормотов")

    @Severity(SeverityLevel.NORMAL)

    @DisplayName("GetWeatherOneDayTest")

    @Description("GET Weather 1 Day")
    void getWeatherOneDay_shouldReturn() {

        Weather response = given()
                .queryParam("apikey", getApiKey())
                .when()
                .get(getBaseUrl()+"/forecasts/v1/daily/1day/294021")
                .then()
                .statusCode(200)
                .time(Matchers.lessThan(2000l))
                .extract()
                .response()
                .body().as(Weather.class);

        Assertions.assertEquals(1,response.getDailyForecasts().size());
    }
}
