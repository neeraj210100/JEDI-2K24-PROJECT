package com.flipfit.business.interfaces;


import com.flipfit.bean.*;

import java.util.List;

//This interface defines the operations that a gym owner can perform within the FlipFit Gym application.
public interface IFlipFitGymOwner {
    //Adds a new gym center to the system.
    public FlipFitGymCentre addCentre(FlipFitGymCentre flipFitGymCentre);
    //Retrieves a list of gym centers managed by the specified gym owner.
    public List<FlipFitGymCentre> viewCentres(FlipFitGymOwner flipFitGymOwner);
//    public  List<FlipFitUser> viewFlipFitCustomers(FlipFitGymCentre flipFitGymCentre);

    //Edits the details of the gym owner.
    public FlipFitGymOwner editDetails(FlipFitGymOwner flipFitGymOwner);
    //Registers a new gym owner in the system.
    public FlipFitGymOwner registerOwner(FlipFitGymOwner owner);
    //Validates the login credentials of a gym owner.
    public FlipFitUser login(FlipFitUser user);
    //Adds a new slot to a gym center.
    FlipFitSlots addSlot(FlipFitSlots flipFitSlot);
}
