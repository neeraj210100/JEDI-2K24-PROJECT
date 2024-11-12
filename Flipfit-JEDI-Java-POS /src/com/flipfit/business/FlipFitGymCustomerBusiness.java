package com.flipfit.business;

import com.flipfit.bean.*;
import com.flipfit.business.interfaces.IFlipFitGymCustomer;
import com.flipfit.dao.classes.FlipFitGymCustomerDAOImpl;
import com.flipfit.dao.classes.FlipFitUserDAOImpl;

import java.util.ArrayList;
import java.util.List;


public class FlipFitGymCustomerBusiness implements IFlipFitGymCustomer {
    private final FlipFitGymCustomerDAOImpl flipFitGymCustomerDAOImpl=new FlipFitGymCustomerDAOImpl();

    public static void updateCustomerProfile(int userId, String newContact) {
        //todo
    }

    public static List<String> getPaymentHistory(int userId) {
        //todo
        return null;
    }

    @Override
    public List<FlipFitBooking> viewBookedSlots(int userId) {

        System.out.println("Viewing booked slots:> ");
        List<FlipFitBooking> bookedSlots = new ArrayList<>();
        return bookedSlots;
    }

    @Override
    public FlipFitBooking checkBookingConflicts(int userId, int slotTime) {
        System.out.println("Checking conflict for slot " + slotTime);
        return new FlipFitBooking();
    }
    @Override
    public List<FlipFitGymCentre> viewCentres() {
        System.out.println("view centres called:> ");
        List<FlipFitGymCentre> viewCentres = new ArrayList<>();
        return viewCentres;
    }

    public boolean makePayment(int userId) {
        System.out.println("Make payment called:> ");

        return true;
    }
    @Override
    public FlipFitGymCustomer editDetails(FlipFitGymCustomer flipFitGymCustomer){
        return flipFitGymCustomerDAOImpl.editDetails(flipFitGymCustomer);
    }
    @Override
    public FlipFitGymCustomer registerCustomer(FlipFitGymCustomer flipFitGymCustomer) {
        FlipFitUser flipFitUser = new FlipFitUser();
        flipFitUser.setPassword(flipFitGymCustomer.getPassword());
        flipFitUser.setEmailID(flipFitGymCustomer.getEmailID());
        flipFitUser.setPhoneNumber(flipFitGymCustomer.getPhoneNumber());
        flipFitUser.setUserName(flipFitGymCustomer.getUserName());
        flipFitUser.setRoleID(1);
        flipFitGymCustomer.setRoleId(1);

        flipFitGymCustomerDAOImpl.addUser(flipFitUser);
        return flipFitGymCustomerDAOImpl.addCustomer(flipFitGymCustomer, flipFitUser);

    }
    @Override
    public FlipFitGymCustomer login(FlipFitUser flipFitUser) {

        FlipFitUserDAOImpl userDAO = new FlipFitUserDAOImpl();
        flipFitUser.setRoleID(1);
        return userDAO.login(flipFitUser.getEmailID(), flipFitUser.getPassword());    }
}
