package com.flipfit.Application;

import com.flipfit.bean.FlipFitAdmin;
import com.flipfit.bean.FlipFitGymCustomer;
import com.flipfit.bean.FlipFitGymOwner;
import com.flipfit.bean.FlipFitUser;
import com.flipfit.business.FlipFitAdminBusiness;
import com.flipfit.business.interfaces.IFlipFitAdmin;
import com.flipfit.dao.classes.FlipFitAdminDAOImpl;

import com.flipfit.business.FlipFitGymCustomerBusiness;
import com.flipfit.business.FlipFitGymOwnerBusiness;
import com.flipfit.business.interfaces.IFlipFitGymCustomer;
import com.flipfit.business.interfaces.IFlipFitGymOwner;
import com.flipfit.dao.classes.FlipFitAdminDAOImpl;
import com.flipfit.dao.classes.FlipFitUserDAOImpl;

import java.util.*;

public class Application {
    private static final IFlipFitGymCustomer flipFitGymCustomerBusiness = new FlipFitGymCustomerBusiness();
    private static final IFlipFitGymOwner flipFitGymOwnerBusiness=new FlipFitGymOwnerBusiness();

    public static void main(String[] args) throws Error {
        try {
            Scanner in = new Scanner(System.in);
            int choice = 0;
            do {
                System.out.println("Welcome To FlipFit: ");
                System.out.println("Type " +
                        "\n 1-> Login, " +
                        "\n 2-> Registration of Customer " +
                        "\n 3-> Registration of Gym Owner " +
                        "\n 4-> Update Password \n"+
                        "\n 5-> Exit \n"
                );

                choice = in.nextInt();
                switch (choice) {
                    case 1: {
                        // Login
                        System.out.println("Login");
                        System.out.print("Enter your emailId:> ");
                        String username = in.next();
                        System.out.print("Enter your password:> ");
                        String password = in.next();
                        System.out.print("Enter your role:> Customer/Admin/GymOwner ");
                        String role = in.next();
//                        System.out.println("Login Successful");

                        switch (role) {
                            case "Customer": {
                                // customer menu
                                FlipFitUserDAOImpl flipFitUserDAO = new FlipFitUserDAOImpl();
                                FlipFitUser gymCustomer =flipFitUserDAO.loginAsCustomer(username, password);
                                if(gymCustomer==null){
                                    System.out.println("Customer not found");
                                    return;
                                }
                                System.out.println("Customer Menu");
                                Customer.getFlipFitCustomerMenu(gymCustomer);
                                break;
                            }
                            case "Admin": {
                                // admin menu
                                FlipFitAdmin admin = new FlipFitAdmin();
                                admin.setEmailID(username);
                                admin.setPassword(password);
                                FlipFitAdminDAOImpl adminDAO = new FlipFitAdminDAOImpl();
                                IFlipFitAdmin flipFitAdmin = new FlipFitAdminBusiness(adminDAO);
                                try {
                                    boolean res=flipFitAdmin.adminLogin(admin);
                                    if(res) {
                                        System.out.println("Admin Menu");
                                        Admin.getAdminView();
                                    }
                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                                break;
                            }
                            case "GymOwner": {
                                // gym owner
                                FlipFitUser gymOwner = new FlipFitUser();
                                gymOwner.setEmailID(username);
                                gymOwner.setPassword(password);


                                System.out.println("GymOwner Menu");
                                GymOwner.getFlipFitOwnerView(gymOwner);
                                break;
                            }
                        }
                        break;
                    }
                    case 2: {
                        System.out.println("Registration of gym customer");
                        System.out.println("Enter your email address:> ");
                        String emailID = in.next();
                        System.out.println("Enter your phone number:> ");
                        String phoneNumber = in.next();
                        System.out.println("Enter your city:> ");
                        String city = in.next();
                        System.out.println("Enter your pin code:> ");
                        String pinCode = in.next();
                        System.out.println("Enter your password:> ");
                        String password = in.next();
                        System.out.println("Enter username: ");
                        String username = in.next();


                        FlipFitUser gymCustomer = new FlipFitUser();
                        gymCustomer.setEmailID(emailID);
                        gymCustomer.setPassword(password);
                        gymCustomer.setPhoneNumber(phoneNumber);
                        gymCustomer.setUserName(username);


                        FlipFitGymCustomer flipFitGymCustomer = new FlipFitGymCustomer();
                        flipFitGymCustomer.setEmailID(emailID);
                        flipFitGymCustomer.setPassword(password);
                        flipFitGymCustomer.setPhoneNumber(phoneNumber);
                        flipFitGymCustomer.setUserName(username);
                        flipFitGymCustomer.setCity(city);
                        flipFitGymCustomer.setPinCode(pinCode);
                        flipFitGymCustomer.setRoleId(1);


                        gymCustomer.setUserID(flipFitGymCustomer.getUserId());

                        flipFitGymCustomerBusiness.registerCustomer(flipFitGymCustomer);
                        System.out.println("Registration completed");
                        System.out.println("Customer Menu");

                        Customer.getFlipFitCustomerMenu(gymCustomer);
                        break;
                    }
                    case 3: {
                        System.out.println("Registration of gym owner");
                        System.out.println("Enter your email address:> ");
                        String emailID = in.next();
                        System.out.println("Enter your phone number:> ");
                        String phoneNumber = in.next();
                        System.out.println("Enter your city:> ");
                        String city = in.next();
                        System.out.println("Enter your pin code:> ");
                        String pinCode = in.next();
                        System.out.println("Enter your password:> ");
                        String password = in.next();
                        System.out.println("Enter username: ");
                        String username = in.next();
                        System.out.println("Enter your panId: ");
                        String panId = in.next();
                        System.out.println("Enter your gstNum: ");
                        String gstNum = in.next();
                        System.out.println("Enter your aadharNumber: ");
                        String aadharNumber = in.next();


                        FlipFitGymOwner flipFitOwner = new FlipFitGymOwner();
                        flipFitOwner.setEmailID(emailID);
                        flipFitOwner.setPassword(password);
                        flipFitOwner.setPhoneNumber(phoneNumber);
                        flipFitOwner.setCity(city);
                        flipFitOwner.setPinCode(pinCode);
                        flipFitOwner.setUserName(username);
                        flipFitOwner.setRoleId(2);
                        flipFitOwner.setGSTIN(gstNum);
                        flipFitOwner.setAadharNumber(aadharNumber);
                        flipFitOwner.setPanId(panId);
                        flipFitOwner.setIsApproved(false);

                        flipFitGymOwnerBusiness.registerOwner(flipFitOwner);

                        System.out.println("Registration completed");

                        break;
                    }
                    case 4: {
                        System.out.println("Update Password not implemented");
                    }
                    case 5: {
                        System.out.println("Exit");
                        break;
                    }
                    default: {
                        throw new Error("Invalid choice entered: " + choice);
                    }
                }
            }
            while (choice != 5);
        } catch (Error e) {

            System.out.println("Please enter a valid choice");
        }
    }
}