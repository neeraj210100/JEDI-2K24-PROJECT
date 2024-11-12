package com.flipfit.business;

import com.flipfit.bean.*;
import com.flipfit.business.interfaces.IFlipFitGymOwner;
import com.flipfit.dao.classes.FlipFitGymCustomerDAOImpl;
import com.flipfit.dao.classes.FlipFitGymOwnerDAOImpl;
import com.flipfit.dao.classes.FlipFitUserDAOImpl;

import java.util.ArrayList;
import java.util.List;

public class FlipFitGymOwnerBusiness implements IFlipFitGymOwner {
    private final FlipFitGymOwnerDAOImpl flipFitGymOwnerDAO=new FlipFitGymOwnerDAOImpl();
    public FlipFitGymOwnerBusiness() {
        // Constructor without DAO implementation
    }

    public FlipFitGymCentre addCentre(FlipFitGymCentre flipFitGymCentre) {
        System.out.println("Adding Centre:");
        return flipFitGymCentre; // Returning the provided object as a placeholder
    }

    public FlipFitSlots addSlot(FlipFitSlots flipFitSlot) {
        System.out.println("Adding Slot: " );
        return flipFitSlot; // Returning the provided object as a placeholder
    }

    public List<FlipFitGymCentre> viewCentres(FlipFitGymOwner flipFitGymOwner) {
        System.out.println("Listing Centres for owner: " + flipFitGymOwner.getUserName());
        return new ArrayList<>(); // Returning an empty list as a placeholder
    }

    public List<FlipFitPayments> viewPayments() {
        System.out.println("Payments listed:> ");
        return null;
    }

    public FlipFitGymOwner editDetails(FlipFitGymOwner owner) {
        System.out.println("Editing details for owner: " + owner.getUserName());
        return flipFitGymOwnerDAO.editDetails(owner); // Returning the provided object as a placeholder
    }

    public FlipFitGymOwner registerOwner(FlipFitGymOwner gymOwner) {
        System.out.println("Registering Gym Owner: " + gymOwner.getUserName());
        gymOwner.setRoleId(2);
        FlipFitUser flipFitUser = new FlipFitUser();
        flipFitUser.setPassword(gymOwner.getPassword());
        flipFitUser.setEmailID(gymOwner.getEmailID());
        flipFitUser.setPhoneNumber(gymOwner.getPhoneNumber());
        flipFitUser.setUserName(gymOwner.getUserName());
        flipFitUser.setRoleID(2);
        gymOwner.setRoleId(2);

        flipFitGymOwnerDAO.addUser(flipFitUser);
        return flipFitGymOwnerDAO.addGymOwner(gymOwner, flipFitUser);// Setting the role as a placeholder
    }

    @Override
    public FlipFitUser login(FlipFitUser flipFitUser) {
        System.out.println("Logging in User: " + flipFitUser.getEmailID());
        FlipFitUserDAOImpl userDAO = new FlipFitUserDAOImpl();
        flipFitUser.setRoleID(2);
        return userDAO.loginAsOwner(flipFitUser.getEmailID(), flipFitUser.getPassword());
    }
}
