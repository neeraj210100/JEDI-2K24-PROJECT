package com.flipfit.dao.interfaces;

import com.flipfit.bean.*;
import java.util.List;
//This interface defines methods for managing gym customer operations within the FlipFit Gym application.
public interface IFlipFitGymCustomerDAO {
    //This method retrieves a list of all slots that have been booked by a specific user.
    public List<FlipFitSlots> viewBookedSlots(int userID);
    //This method checks for booking conflicts for a user at a specified slot time.
    public FlipFitBooking checkBookingConflicts(int userId, int slotTime);
    //This method retrieves a list of all gym centres available in the system.
    public List<FlipFitGymCentre> viewCentres();
    //This method processes a payment for a specific user.
    public boolean makePayment(int userID);
    //This method retrieves the payment details for a specific user.
    public void viewPaymentDetails(int userID);
    public FlipFitUser addUser(FlipFitUser user);
    //This method edits customer details to the system.
    public FlipFitGymCustomer editDetails(FlipFitGymCustomer customer);
    //This method adds a new customer to the system along with user details.
    public FlipFitGymCustomer addCustomer(FlipFitGymCustomer customer, FlipFitUser user);
}