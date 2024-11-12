package com.flipfit.dao.interfaces;

import com.flipfit.bean.FlipFitBooking;
import com.flipfit.bean.FlipFitGymOwner;
import com.flipfit.bean.FlipFitUser;
import java.util.ArrayList;
import java.util.List;
//This interface defines methods for managing bookings within the FlipFit Gym application.
public interface IFlipFitBookingDAO {
    //This method creates a new booking in the system.
    public FlipFitBooking makeBooking(FlipFitBooking booking);
    //This method deletes an existing booking from the system.
    boolean deleteBooking(int bookingId);
    //This method retrieves all bookings made by a specific user.
    public List<FlipFitBooking> getAllBookings(int userId);
    //Retrieves detailed information about a specific booking by its ID.
    public List<FlipFitBooking> getBookingDetails(int bookingId);
    //This is a list that may be used to store or reference all booking records.
    public List<FlipFitBooking> bookings = new ArrayList<>();
}