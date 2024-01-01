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



public class GetWeather15DayTest extends AccuweatherAbstractTest{
@Test

@Link("http://dataservice.accuweather.com/forecasts/v1/daily/15day/{locationKey}")

@Owner("Алексей Бормотов")

@Severity(SeverityLevel.NORMAL)

@DisplayName("GetWeather15DayTest")

@Description("GET Weather 15 Days")

   void testGetResponse15() {

       Weather weather = given().queryParam("apikey", getApiKey()).pathParam("locationKey", 50)

               .when().get(getBaseUrl() + "/forecasts/v1/daily/15day/{locationKey}")

               .then().statusCode(200).time(lessThan(2000L))

               .extract().response().body().as(Weather.class);

       Assertions.assertEquals(5, weather.getDailyForecasts().size());

       System.out.println(weather);

   }
}
