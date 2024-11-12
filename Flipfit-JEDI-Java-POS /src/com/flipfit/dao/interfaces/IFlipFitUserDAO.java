package com.flipfit.dao.interfaces;

import com.flipfit.bean.FlipFitGymCustomer;
import com.flipfit.bean.FlipFitUser;

//This interface defines methods for managing user operations within the FlipFit Gym application.
public interface IFlipFitUserDAO {
    FlipFitUser loginAsCustomer(String emailID, String password);

    FlipFitUser loginAsOwner(String emailID, String password);

    //Authenticates a user based on their email ID and password.
    public FlipFitGymCustomer login(String emailID, String password);
    //Adds a new user to the system.
    public void addUser(FlipFitUser ffu);
    //Deletes an existing user
    public void deleteUser(FlipFitUser ffu);
//Updates the details of an existing user.
    public void changeUser(FlipFitUser ffu);
    //Retrieves detailed information about a specific user by their ID.
    public FlipFitUser getUser(int userID);
}