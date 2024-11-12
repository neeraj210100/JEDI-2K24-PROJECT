package com.flipfit.business;

import com.flipfit.bean.*;
import com.flipfit.business.interfaces.IFlipFitAdmin;
import com.flipfit.dao.classes.FlipFitAdminDAOImpl;
import com.flipfit.dao.interfaces.IFlipFitAdminDAO;

import java.util.List;

public class FlipFitAdminBusiness implements IFlipFitAdmin {
    private final FlipFitAdminDAOImpl flipFitAdminDAOImpl ;
    public FlipFitAdminBusiness(FlipFitAdminDAOImpl FFAdmin){
        this.flipFitAdminDAOImpl=FFAdmin;
    }

    public boolean adminLogin(FlipFitAdmin flipFitAdmin) {
        System.out.println("AdminUserBusiness.adminLogin");
        return flipFitAdminDAOImpl.adminLogin(flipFitAdmin);
    }

    public List<FlipFitGymOwner> getPendingOwnerList() {
        System.out.println("AdminUserBusiness.getPendingOwnerList");
        return flipFitAdminDAOImpl.getPendingOwnerList();
    }

    public List<FlipFitGymOwner> getApprovedOwnerList() {
        System.out.println("AdminUserBusiness.getApprovedOwnerList");
        return flipFitAdminDAOImpl.getApprovedOwnerList();
    }

    public List<FlipFitGymCustomer> getUserList() {
        System.out.println("AdminUserBusiness.getUserList");
        return flipFitAdminDAOImpl.getUserList();
    }

    public boolean validateOwner(int ownerId) {
        return flipFitAdminDAOImpl.validateOwner(ownerId);
    }

    public boolean deleteOwner(int ownerId) {
        System.out.println("AdminUserBusiness.deleteOwner " + ownerId);
        flipFitAdminDAOImpl.deleteOwner(ownerId);
        return true;
    }

    public List<FlipFitGymCentre> getGymCentreUsingOwnerId(int ownerId) {
        System.out.println("AdminUserBusiness.getGymCentreUsingOwnerId " + ownerId);
        return flipFitAdminDAOImpl.getGymCentreUsingOwnerId(ownerId);
    }
}
