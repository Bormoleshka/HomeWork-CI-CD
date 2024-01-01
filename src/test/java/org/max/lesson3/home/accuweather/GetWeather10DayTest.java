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


