package com.flipfit.restController;
import com.flipfit.business.FlipFitGymCustomerBusiness;
import com.flipfit.business.interfaces.IFlipFitBookings;
import com.flipfit.exceptions.InvalidChoiceException;
import com.flipfit.bean.FlipFitBooking;
import com.flipfit.bean.FlipFitGymCentre;
import com.flipfit.bean.FlipFitGymCustomer;
import  com.flipfit.business.interfaces.IFlipFitGymCustomer;
import com.flipfit.bean.FlipFitUser;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/customer")
@Produces(MediaType.APPLICATION_JSON)

public class CustomerController {
    private final IFlipFitGymCustomer flipFitCustomerBusiness;
    private FlipFitGymCustomer flipFitGymCustomer;
    private FlipFitUser flipFitUser;
    @Inject
    public CustomerController(FlipFitGymCustomerBusiness flipFitGymCustomerService) {
        this.flipFitCustomerBusiness = flipFitGymCustomerService;
    }
    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    public FlipFitGymCustomer login(FlipFitUser user){
        FlipFitGymCustomer customer = flipFitCustomerBusiness.login(user);
        this.flipFitGymCustomer = customer;
        return flipFitGymCustomer;
    }
    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    public FlipFitGymCustomer register(FlipFitGymCustomer flipFitGymCustomer){
        FlipFitGymCustomer customer = flipFitCustomerBusiness.registerCustomer(flipFitGymCustomer);
        this.flipFitGymCustomer = customer;
        return flipFitGymCustomer;
    }
    @GET
    @Path("/viewBookings/{userId}")
    public List<FlipFitBooking> viewBookings(@PathParam("userId") int userId){
        return flipFitCustomerBusiness.viewBookedSlots(userId);
    }

    @GET
    @Path("/viewCentres")
    @Consumes(MediaType.APPLICATION_JSON)
    public List<FlipFitGymCentre> viewCentres(){
        return flipFitCustomerBusiness.viewCentres();
    }
    @PUT
    @Path("/editDetails")
    @Consumes(MediaType.APPLICATION_JSON)
    public FlipFitGymCustomer editDetails(FlipFitGymCustomer flipFitGymCustomer) throws InvalidChoiceException {
        return flipFitCustomerBusiness.editDetails(flipFitGymCustomer);
    }
//    @POST
//    @Path("/makeBooking")
//    @Consumes(MediaType.APPLICATION_JSON)
//    public FlipFitBooking makeBooking(FlipFitBooking flipFitBooking) throws InvalidChoiceException {
//        return flipFitCustomerBusiness.makeBooking(flipFitBooking);
//    }
//    @DELETE
//    @Path("/deleteBooking/{bookingId}")
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Boolean deleteBooking(@PathParam("userId") int bookingId) throws InvalidChoiceException {
//        return flipFitCustomerBusiness.deleteBooking(bookingId);
//    }
}
