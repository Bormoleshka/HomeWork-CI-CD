import io.restassured.http.Method;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;

import seminar.accuweather.location.Location;

import seminar.accuweather.weather.Weather;



import java.util.HashMap;

import java.util.List;

import java.util.Map;



import static io.restassured.RestAssured.given;

import static org.hamcrest.Matchers.lessThan;


public class GetWeather10DayTest extends AccuweatherAbstractTest{
@Test

   void testGetResponse() {

       Weather weather = given().queryParam("apikey", getApiKey()).pathParam("locationKey", 50)

               .when().get(getBaseUrl() + "/forecasts/v1/daily/10day/{locationKey}")

               .then().statusCode(200).time(lessThan(2000L))

               .extract().response().body().as(Weather.class);

       Assertions.assertEquals(5, weather.getDailyForecasts().size());

       System.out.println(weather);

   }
}


