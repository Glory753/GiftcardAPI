package Model;

public class Contact {

    public int contactID;

    public String firstName;

    public String lastName;

    public String phoneNumber;

    public String emailAddress;

    public String feedback;

    public int giftcardID;

    public Contact(int contactID, String firstName, String lastName, String phoneNumber, String emailAddress, String feedback, int giftcardID) {
        this.contactID = contactID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.feedback = feedback;
        this.giftcardID = giftcardID;
    }

    public String toString() {
        return "Contact {" +
                "contactID="  + contactID + '\'' +
                "firstName=" + firstName + '\'' +
                "lastName=" + lastName + '\'' +
                "phoneNumber=" + phoneNumber + '\'' +
                "emailAddress=" + emailAddress + '\'' +
                "feedback=" + feedback + '\'' +
                "giftcardID=" + giftcardID + '\'' +
                "}\n";
    }

    public int getContactID() {
        return contactID;
    }

    public void setContactID(int contactID) {
        this.contactID = contactID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public int getGiftcardID() {
        return giftcardID;
    }

    public void setGiftcardID(int giftcardID) {
        this.giftcardID = giftcardID;
    }
}

