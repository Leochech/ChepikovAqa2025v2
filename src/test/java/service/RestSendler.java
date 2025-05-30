package service;

import io.restassured.http.ContentType;
import pojo.*;

import static io.restassured.RestAssured.given;

public class RestSendler {

    public String getAuthToken() {
        AuthRequest authRequest = new AuthRequest("admin", "password123");
        var response = given()
                .header("Content-Type", "application/json")
                .body(authRequest)
                .post("/auth")
                .then()
                .statusCode(200)
                .extract()
                .as(AuthResponse.class);
        return response.getToken();
    }

    public int createBooking() {
        Booking booking = new Booking("Jim", "Brown", 123, true,
                new BookingDates("2024-01-01", "2024-01-02"), "Breakfast");

        var response = given()
                .contentType(ContentType.JSON)
                .body(booking)
                .post("/booking")
                .then()
                .statusCode(200)
                .extract()
                .as(BookingResponse.class);

        return response.getBookingid();
    }
}
