package com.flipfit.business.interfaces;

import com.flipfit.bean.FlipFitBooking;
import com.flipfit.bean.FlipFitGymCentre;
import com.flipfit.bean.FlipFitGymCustomer;
import com.flipfit.bean.FlipFitUser;

import java.util.List;

//This interface defines methods for managing customer operations within the FlipFit Gym application.
public interface IFlipFitGymCustomer {
    //Retrieves a list of booked slots for a specific user.
    public List<FlipFitBooking> viewBookedSlots(int userId);
    //Checks for booking conflicts for a specific user at a given slot time.
    public FlipFitBooking checkBookingConflicts(int userId, int slotTime);
    //Retrieves a list of all gym centers.
    public List<FlipFitGymCentre> viewCentres();
    //Edits the details of an existing customer.
    public FlipFitGymCustomer editDetails(FlipFitGymCustomer flipFitGymCustomer);
    //Authenticates a customer login using provided user details.
    public FlipFitGymCustomer login(FlipFitUser flipFitUser);
    //Registers a new customer in the system.
    public FlipFitGymCustomer registerCustomer(FlipFitGymCustomer flipFitGymCustomer);
}
