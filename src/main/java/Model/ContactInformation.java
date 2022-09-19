package Model;

import DAO.ContactRepository;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.Scanner;

public class ContactInformation {

    public static Logger logger = Logger.getLogger(ContactInformation.class);

    public static void menu(Scanner in) throws SQLException {

        logger.info("info text");

        boolean contactInformation = true;
        ContactRepository cr = new ContactRepository();
        while (contactInformation) {
            System.out.println("Select options: view all contacts, add contact, remove contact, quit");
            String line = in.nextLine();
            if (line.equals("quit")) {
                contactInformation = false;
            } else if (line.equals("add contact")) {
                System.out.println(("contactID: "));
                int contactID = Integer.parseInt(in.nextLine());
                System.out.println(("First Name: "));
                String firstName = in.nextLine();
                System.out.println(("Last Name: "));
                String lastName = in.nextLine();
                System.out.println(("Phone Number: "));
                String phoneNumber = in.nextLine();
                System.out.println(("Email Address: "));
                String emailAddress = in.nextLine();
                System.out.println(("Feedback: "));
                String feedback = in.nextLine();
                System.out.println(("giftcardID: "));
                int giftcardID = Integer.parseInt(in.nextLine());
                Contact newContact = new Contact(contactID, firstName, lastName, phoneNumber, emailAddress, feedback, giftcardID);
                cr.addContact(newContact);
            } else if (line.equals("view all contacts")) {
                System.out.println(cr.getAllContacts());
            } else if (line.equals("remove contact")) {
                System.out.println(" Contact ID: ");
                int customerID = Integer.parseInt(in.nextLine());
                cr.removeContact(customerID);
            }
        }
    }
}
