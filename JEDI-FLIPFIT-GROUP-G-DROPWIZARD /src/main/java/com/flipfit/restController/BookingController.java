package com.flipfit.restController;
import com.flipfit.business.BookingsBusiness;
import com.flipfit.bean.FlipFitBooking;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/booking")
@Produces(MediaType.APPLICATION_JSON)

public class BookingController {
    private final BookingsBusiness bookingService;

    @Inject
    public BookingController(BookingsBusiness bookingsService) {
        this.bookingService =  bookingsService;
    }
    @POST
    @Path("/add/centreID/{centreID}/startTime/{startTime}/userID/{userID}")
    public FlipFitBooking addBooking(@PathParam("centreID") int centreID, @PathParam("startTime") int startTime, @PathParam("userID") int userID){
        return bookingService.makeBooking(userID, centreID, startTime);
    }
    @DELETE
    @Path("/delete/bookingID/{bookingID}")
    public boolean deleteBooking(@PathParam("bookingID") int bookingID){
        return bookingService.deleteBooking(bookingID);
    }

}
