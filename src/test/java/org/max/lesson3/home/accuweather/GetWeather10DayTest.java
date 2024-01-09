package org.max.lesson3.home.accuweather;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.max.lesson3.home.accuweather.weather.Weather;
import org.max.lesson3.home.accuweather.location.Location;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;
@Epic(value = "Тестирование API https://developer.accuweather.com/accuweather-forecast-api/apis")
@Feature(value = "Домашняя работа 6")


public class GetWeather10DayTest extends AccuweatherAbstractTest{
@Test
@Link("http://dataservice.accuweather.com/forecasts/v1/daily/10day/{locationKey}")
@Owner("Алексей Бормотов")
@Severity(SeverityLevel.NORMAL)
@DisplayName("GetWeather10DayTest")
@Description("GET Weather 10 Days")
   void testGetResponse() {

       Weather weather = given().queryParam("apikey", getApiKey()).pathParam("locationKey", 50)

               .when().get(getBaseUrl() + "/forecasts/v1/daily/10day/{locationKey}")

               .then().statusCode(200).time(lessThan(2000L))

               .extract().response().body().as(Weather.class);

       Assertions.assertEquals(5, weather.getDailyForecasts().size());

       System.out.println(weather);

   }
}


