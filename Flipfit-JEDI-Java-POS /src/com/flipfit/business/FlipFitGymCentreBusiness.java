package com.flipfit.business;
import com.flipfit.bean.FlipFitGymCentre;
import com.flipfit.bean.FlipFitSlots;
import com.flipfit.business.interfaces.IFlipFitGymCentre;

import java.util.ArrayList;
import java.util.List;

public class FlipFitGymCentreBusiness implements IFlipFitGymCentre {


    public static void updateCapacity(int centreID, int newCapacity) {
        //todo
    }

    public static void updateSlotAvailability(int centreID, int slotID, int newSeatsAvailable) {
        //todo
    }

    public FlipFitGymCentre updateGymCentre(FlipFitGymCentre flipFitGymCentre){
        System.out.println("Updating Gym Centre:> ");
        return flipFitGymCentre;
    }

    public boolean deleteGymCentre(int centreId){
        System.out.println("Deleting Gym Centre:> ");
        FlipFitGymCentre flipFitGymCentre = new FlipFitGymCentre();
        return true;
    }

    public List<FlipFitSlots> viewAvailableSlots(int centreId) {
        System.out.println("Viewing Available Slots:> ");

        List<FlipFitSlots> availableSlots = new ArrayList<>();
        return availableSlots;
    }
}
