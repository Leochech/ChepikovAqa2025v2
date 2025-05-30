package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pojo.Booking;
import pojo.BookingDates;
import pojo.BookingId;
import pojo.BookingResponse;
import settings.BaseTest;

import static io.restassured.RestAssured.given;

class BackEndTests extends BaseTest {

    @Test
    @DisplayName("CreateBooking")
    void createBookingAndValidResponse() {
        Booking booking = new Booking("Jim", "Brown", 123, true,
                new BookingDates("2024-01-01", "2024-01-02"), "Breakfast");

        var response = given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .body(booking)
                .when()
                .post("/booking")
                .then()
                .statusCode(200)
                .extract()
                .as(BookingResponse.class);

        Booking bookingResponse = response.getBooking();

        softAssertions
                .assertThat(bookingResponse.getFirstname())
                .as("Это не Джим!")
                .isEqualTo(booking.getFirstname());
        softAssertions
                .assertThat(bookingResponse.getLastname())
                .as("Это не Коричневый!")
                .isEqualTo(booking.getLastname());
        softAssertions
                .assertThat(bookingResponse.getTotalprice())
                .as("Это не 123!")
                .isEqualTo(booking.getTotalprice());
        softAssertions
                .assertThat(bookingResponse.getBookingdates().getCheckin())
                .as("Это не 2024-01-01!")
                .isEqualTo(booking.getBookingdates().getCheckin());
        softAssertions
                .assertThat(bookingResponse.getBookingdates().getCheckout())
                .as("Это не 2024-01-02!")
                .isEqualTo(booking.getBookingdates().getCheckout());
        softAssertions
                .assertThat(bookingResponse.getAdditionalneeds())
                .as("Это не Breakfast!")
                .isEqualTo(booking.getAdditionalneeds());
        softAssertions.assertAll();
    }

    @Test
    @DisplayName("UpdateBooking")
    void updateBookingAndValidResponse() {

        int bookingId = rest.createBooking();

        String token = rest.getAuthToken();

        Booking updateBooking = new Booking("James", "Smith", 200, false,
                new BookingDates("2024-02-01", "2024-02-10"), "Lunch");

        var updatedBooking = given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Cookie", "token=" + token)
                .body(updateBooking)
                .when()
                .put("/booking/" + bookingId)
                .then()
                .statusCode(200)
                .extract()
                .as(Booking.class);

        softAssertions
                .assertThat(updatedBooking.getFirstname())
                .as("Firstname не обновился!")
                .isEqualTo(updateBooking.getFirstname());
        softAssertions
                .assertThat(updatedBooking.getLastname())
                .as("Lastname не обновился!")
                .isEqualTo(updateBooking.getLastname());
        softAssertions
                .assertThat(updatedBooking.getTotalprice())
                .as("Totalprice не обновился!")
                .isEqualTo(updateBooking.getTotalprice());
        softAssertions
                .assertThat(updatedBooking.getBookingdates().getCheckin())
                .as("Checkin date не обновился!")
                .isEqualTo(updateBooking.getBookingdates().getCheckin());
        softAssertions
                .assertThat(updatedBooking.getBookingdates().getCheckout())
                .as("Checkout date не обновился!")
                .isEqualTo(updateBooking.getBookingdates().getCheckout());
        softAssertions
                .assertThat(updatedBooking.getAdditionalneeds())
                .as("Additional needs не обновились!")
                .isEqualTo(updateBooking.getAdditionalneeds());
        softAssertions.assertAll();
    }

    @Test
    @DisplayName("DeleteBooking")
    void deleteBookingAndValidResponse() {

        int bookingId = rest.createBooking();

        String token = rest.getAuthToken();

        given()
                .header("Content-Type", "application/json")
                .header("Cookie", "token=" + token)
                .when()
                .delete("/booking/" + bookingId)
                .then()
                .statusCode(201);

        given()
                .header("Accept", "application/json")
                .when()
                .get("/booking/" + bookingId)
                .then()
                .statusCode(404);
    }

    @Test
    @DisplayName("GetBookings")
    void getBookingsAndValidResponse() {

        rest.createBooking();

        BookingId[] bookings = given()
                .header("Accept", "application/json")
                .when()
                .get("/booking")
                .then()
                .statusCode(200)
                .extract()
                .as(BookingId[].class);

        softAssertions
                .assertThat(bookings)
                .as("Список бронирований пуст!")
                .isNotEmpty();
        softAssertions.assertAll();

    }
}
