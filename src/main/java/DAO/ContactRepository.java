package DAO;

import java.util.ArrayList;
import java.sql.*;
import java.util.List;

import Model.Contact;
import Model.ContactInformation;
import Util.ConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static Util.ConnectionUtil.getConnection;

public class ContactRepository {

    Connection conn;

    public ContactRepository() throws SQLException { conn = getConnection(); }

    public List<Contact> getAllContacts() {
        List<Contact> allContacts = new ArrayList<>();
        ContactInformation.logger.info("getting all Contact information");
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("Select * From contact");
            while (rs.next()) {
                Contact loadedContact = new Contact(rs.getInt("contactID"), rs.getString("firstName"), rs.getString("lastName"), String.valueOf(rs.getInt("phoneNumber")), rs.getString("emailAddress"), rs.getString("feedback"), rs.getInt("giftcardID"));
                allContacts.add(loadedContact);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allContacts;
    }

    public void addContact(Contact c) {
        ContactInformation.logger.info("adding Contact information");
        try {
            ContactRepository pr = new ContactRepository();
            PreparedStatement statement = conn.prepareStatement("insert into Contact (contactID, firstName, lastName, phoneNumber, emailAddress, feedback, giftcardID) " + "values (?, ?, ?, ?, ?, ?, ?)");
            statement.setInt(1, c.getContactID());
            statement.setString(2,c.getFirstName());
            statement.setString(3,c.getLastName());
            statement.setString(4,c.getPhoneNumber());
            statement.setString(5, c.getEmailAddress());
            statement.setString(6,c.getFeedback());
            statement.setInt(7,c.getGiftcardID());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Contact> getContactByLastName(String LastName) {
        ContactInformation.logger.info("getting Contact by last name");
        List<Contact> allContacts = new ArrayList<>();
        try {
            PreparedStatement statement = conn.prepareStatement("Select * From Contact Where lastName = ?");
            statement.setString(1, LastName);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Contact loadedContact = new Contact(rs.getInt("contactID"), rs.getString("firstName"), rs.getString("lastName"), String.valueOf(rs.getInt("phoneNumber")), rs.getString("emailAddress"), rs.getString("feedback"), rs.getInt("giftcardID"));
                allContacts.add(loadedContact);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allContacts;
    }

    public List<Contact> getContactByContactID(int id) {
        ContactInformation.logger.info("getting Contact by ID");

        List<Contact> allContacts = new ArrayList<>();
        try {
            PreparedStatement statement = conn.prepareStatement("Select * From contact Where contactID = ?");
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Contact loadedContact = new Contact(rs.getInt("contactID"), rs.getString("firstName"), rs.getString("lastName"), String.valueOf(rs.getInt("phoneNumber")), rs.getString("emailAddress"), rs.getString("feedback"), rs.getInt("giftcardID"));
                allContacts.add(loadedContact);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allContacts;
    }
    public List<Contact> getContactByFeedback(String feedback) {
        ContactInformation.logger.info("getting Contact by Feedback");

        List<Contact> allContacts = new ArrayList<>();
        try {
            PreparedStatement statement = conn.prepareStatement("Select * From Contact Where feedback = ?");

            statement.setString(1, feedback);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Contact loadedContact = new Contact(rs.getInt("contactID"), rs.getString("firstName"), rs.getString("lastName"), String.valueOf(rs.getInt("phoneNumber")), rs.getString("emailAddress"), rs.getString("feedback"), rs.getInt("giftcardID"));
                allContacts.add(loadedContact);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allContacts;
    }
    public void removeContact(int id) {
        ContactInformation.logger.info("removing Contact information");
        try {
            PreparedStatement statement = conn.prepareStatement("delete from contact where contactID = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Contact> getContactByGiftcardID(int id) {
        ContactInformation.logger.info("getting contact by giftcardID");

        List<Contact> allContacts = new ArrayList<>();
        try {
            PreparedStatement statement = conn.prepareStatement("Select * From giftcard inner join contact on giftcard.id = contact.giftcardID");
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Contact loadedPatient = new Contact(rs.getInt("contactID"), rs.getString("firstName"), rs.getString("lastName"), String.valueOf(rs.getInt("phoneNumber")), rs.getString("emailAddress"), rs.getString("feedback"), rs.getInt("giftcardID"));
                allContacts.add(loadedPatient);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allContacts;
    }
}
