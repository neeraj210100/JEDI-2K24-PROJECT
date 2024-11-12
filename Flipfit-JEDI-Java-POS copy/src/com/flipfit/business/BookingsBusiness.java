package com.flipfit.business;

import com.flipfit.bean.FlipFitBooking;
import com.flipfit.bean.FlipFitSlots;
import com.flipfit.dao.classes.FlipFitBookingDAOImpl;

import java.util.List;


public class BookingsBusiness {


    public static FlipFitBooking makeBooking(int userID, int centreID, int slotId,int slotTime) {

        System.out.println("Making a booking for " + userID);
        FlipFitBookingDAOImpl flipFitBookingDAO = new FlipFitBookingDAOImpl();
        FlipFitBooking booking = new FlipFitBooking();
        booking.setUserId(userID);
        booking.setSlotTime(slotTime);
        booking.setSlotId(slotId);
        booking.setIsdeleted(false);
        return flipFitBookingDAO.makeBooking(booking);
    }

    public static List<Integer> getBookingsByCentreOwner(int userID) {
        //todo
        return null;
    }

    public static boolean deleteBooking(int bookingId) {
        System.out.println("Deleting a booking for " + bookingId);
        FlipFitBookingDAOImpl flipFitBookingDAO = new FlipFitBookingDAOImpl();
        return flipFitBookingDAO.deleteBooking(bookingId);
    }
}
