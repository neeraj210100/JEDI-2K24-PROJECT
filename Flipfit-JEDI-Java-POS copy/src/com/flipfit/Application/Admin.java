package com.flipfit.Application;

import com.flipfit.bean.*;
import com.flipfit.bean.FlipFitAdmin;
import com.flipfit.business.FlipFitAdminBusiness;
import com.flipfit.business.FlipFitGymOwnerBusiness;
import com.flipfit.business.interfaces.IFlipFitAdmin;
import com.flipfit.dao.classes.FlipFitAdminDAOImpl;
import com.flipfit.dao.classes.FlipFitAdminDAOImpl;
import com.flipfit.dao.interfaces.IFlipFitAdminDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Admin {
    public static void getAdminView() throws Error {
        try {
            Scanner sc = new Scanner(System.in);
            FlipFitAdminDAOImpl adminUser = new FlipFitAdminDAOImpl();
            FlipFitAdminBusiness adminService = new FlipFitAdminBusiness(adminUser);

//            IFlipFitAdminDAO adminDAO = new FlipFitAdminDAOImpl();
//            FlipFitAdminBusiness adminBusiness = new FlipFitAdminBusiness(adminDAO);

            System.out.println("1. View Pending Requests");
            System.out.println("2. View Approved Owners");
            System.out.println("3. View all FlipFit Customers");
            System.out.println("4. View all Centres Using OwnerId");
            System.out.println("5. Delete Customer/Owner");
            int choice = sc.nextInt();

            switch (choice) {
                case 1: {
                    List<FlipFitGymOwner> flipFitGymOwnerList = adminService.getPendingOwnerList();
                    for (FlipFitGymOwner flipFitGymOwner : flipFitGymOwnerList) {
                        System.out.println("Owner ID :" + flipFitGymOwner.getUserId() + " Aadhar :" + flipFitGymOwner.getAadharNumber());
                    }
                    System.out.println("Type the ownerId of owner you wish to approve");
                    String ownerId = sc.next();
                    // TODO  Approve owner

                }
                case 2: {
                    System.out.println("Printing list of Approved Owners");
                    List<FlipFitGymOwner> flipFitGymOwnerList = adminService.getApprovedOwnerList();
                    for (FlipFitGymOwner flipFitGymOwner : flipFitGymOwnerList) {
                        System.out.println("Owner ID :" + flipFitGymOwner.getUserId() + " Aadhar :" + flipFitGymOwner.getAadharNumber());
                    }
                    break;
                }
                case 3: {
                    List<FlipFitGymCustomer> customersList = adminService.getUserList();
                    for (FlipFitGymCustomer customers : customersList) {
                        System.out.println("CustomerID: " + customers.getUserId() + " CustomerName :" + customers.getUserName());
                    }

                    break;
                }
                case 4: {
                    System.out.println("Type the ownerId of owner for which you wish to view Centres");
                    Scanner in = new Scanner(System.in);
                    int ownerId = in.nextInt();
                    List<FlipFitGymCentre> flipFitGymCentres = adminService.getGymCentreUsingOwnerId(ownerId);
                    if (flipFitGymCentres.isEmpty()) {
                        System.out.println("No centres found for owner ID " + ownerId);
                    } else {
                        System.out.println("Printing All Centres of Owner");
                        for (FlipFitGymCentre gymCentre : flipFitGymCentres) {
                            System.out.println("CentreID: " + gymCentre.getCentreID() + " City :" + gymCentre.getCity() + " Capacity: " + gymCentre.getCapacity());
                        }
                    }
                    break;
                }
                case 5: {
                    System.out.println("Do you want to delete a Customer or Gym Owner? (Enter 'Customer' or 'Owner')");
                    String userType = sc.next();

                    if (userType.equalsIgnoreCase("Customer")) {
                        //changes required here
                        List<FlipFitGymCustomer> customersList = new ArrayList<>();
                        for (FlipFitGymCustomer customer : customersList) {
                            System.out.println("CustomerID: " + customer.getUserId() + " CustomerName: " + customer.getUserName());
                        }
                        System.out.println("Enter the CustomerID of the customer you wish to delete:");
                        String customerId = sc.next();
                        // TODO: Implement customer deletion logic
                        System.out.println("Customer with ID " + customerId + " has been deleted.");
                    } else if (userType.equalsIgnoreCase("Owner")) {
                        //changes required here
                        List<FlipFitGymOwner> flipFitGymOwnerList = new ArrayList<>();
                        for (FlipFitGymOwner owner : flipFitGymOwnerList) {
                            System.out.println("Owner ID: " + owner.getUserId() + " Aadhar: " + owner.getAadharNumber());
                        }
                        System.out.println("Enter the OwnerID of the owner you wish to delete:");
                        String ownerId = sc.next();
                        // TODO: Implement gym owner deletion logic
                        System.out.println("Gym Owner with ID " + ownerId + " has been deleted.");
                    } else {
                        System.out.println("Invalid option. Please choose 'Customer' or 'Owner'.");
                    }
                    break;
                }
                default: {
                    throw new Error("Invalid choice entered: " + choice);
                }
            }
        } catch (Error e) {
            System.out.println("Please enter a valid choice");
        }
    }
}
