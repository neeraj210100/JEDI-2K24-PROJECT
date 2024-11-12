package com.flipfit.dao.classes;

import com.flipfit.bean.*;
import com.flipfit.dao.interfaces.IFlipFitGymCustomerDAO;

import java.util.*;
import java.sql.*;


public class FlipFitGymCustomerDAOImpl implements IFlipFitGymCustomerDAO {

    @Override
    public List<FlipFitSlots> viewBookedSlots(int userID) {
        List<FlipFitSlots> bookedSlots = new ArrayList<>();
        String sql = "SELECT * FROM Booking WHERE userID = ? and isDeleted=FALSE";

        try (Connection conn = GetConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userID);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                FlipFitSlots slot = new FlipFitSlots();
                slot.setSlotId(rs.getInt("slotID"));
                bookedSlots.add(slot);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bookedSlots;
    }

    @Override
    public FlipFitBooking checkBookingConflicts(int userId, int slotTime) {
        String sql = "SELECT * FROM Booking WHERE userID = ? and slotTime = ?";
        try (Connection conn = GetConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            stmt.setInt(2, slotTime);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    FlipFitBooking booking = new FlipFitBooking();
                    booking.setSlotTime(rs.getInt("slotTime"));
                    booking.setSlotId(rs.getInt("slotID"));
                    booking.setUserId(userId);
                    booking.setBookingId(rs.getInt("bookingID"));
                    booking.setIsdeleted(rs.getBoolean("isDeleted"));
                    return booking;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<FlipFitGymCentre> viewCentres() {
        List<FlipFitGymCentre> gymcentres = new ArrayList<>();
        String sql = "SELECT * FROM GymCentre";
        try (Connection conn = GetConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                FlipFitGymCentre gymcentre = new FlipFitGymCentre();
                gymcentre.setCentreID(rs.getInt("centreID"));
                gymcentre.setOwnerID(rs.getInt("ownerID"));
                gymcentre.setCapacity(rs.getInt("capacity"));
                gymcentre.setCity(rs.getString("city"));
                gymcentre.setPincode(rs.getString("pincode"));
                gymcentres.add(gymcentre);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return gymcentres;
    }

    @Override
    public boolean makePayment(int userID) {
        return false;
    }

    @Override
    public void viewPaymentDetails(int userID) {

    }

    public void editPaymentDetails(int userID) {

    }

    @Override
    public FlipFitGymCustomer editDetails(FlipFitGymCustomer customer) {
        String sql = "UPDATE Customer SET city=?, pincode=? WHERE customerID=?";

        try (Connection conn = GetConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, customer.getCity());
            stmt.setString(2, customer.getPinCode());
            stmt.setInt(3, customer.getUserId());
            int affectedRows = stmt.executeUpdate(); // Use executeUpdate() for INSERT
            if (affectedRows == 0) {
                throw new SQLException("Updating GymCustomer failed, no rows affected.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        sql = "UPDATE User SET userName=?, roleID=?, emailID=?, phoneNumber=?, password=? WHERE userID=?";

        try (Connection conn = GetConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, customer.getUserName());
            stmt.setInt(2, customer.getRoleId());
            stmt.setString(3, customer.getEmailID());
            stmt.setString(4, customer.getPhoneNumber());
            stmt.setString(5, customer.getPassword());
            stmt.setInt(6, customer.getUserId());
            int affectedRows = stmt.executeUpdate(); // Use executeUpdate() for INSERT
            if (affectedRows == 0) {
                throw new SQLException("Updating GymUser failed, no rows affected.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customer;
    }
    @Override
    public FlipFitUser addUser(FlipFitUser user) {
        String sql = "INSERT INTO User (userName, roleID, emailID, phoneNumber, password) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = GetConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, user.getUserName());
            stmt.setInt(2, user.getRoleID());
            stmt.setString(3, user.getEmailID());
            stmt.setString(4, user.getPhoneNumber());
            stmt.setString(5, user.getPassword());
            int affectedRows = stmt.executeUpdate(); // Use executeUpdate() for INSERT
            if (affectedRows == 0) {
                throw new SQLException("Creating user failed, no rows affected.");
            }

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int userID = generatedKeys.getInt(1);
                    user.setUserID(userID);
                } else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public FlipFitGymCustomer addCustomer(FlipFitGymCustomer customer, FlipFitUser user) {
        String sql = "INSERT INTO Customer (customerID, city, pincode) VALUES (?, ?, ?)";
        try (Connection conn = GetConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, user.getUserID());
            stmt.setString(2, customer.getCity());
            stmt.setString(3, customer.getPinCode());
            int affectedRows = stmt.executeUpdate(); // Use executeUpdate() for INSERT
            if (affectedRows == 0) {
                throw new SQLException("Creating customer failed, no rows affected.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        customer.setUserId(user.getUserID());
        return customer;
    }
}

