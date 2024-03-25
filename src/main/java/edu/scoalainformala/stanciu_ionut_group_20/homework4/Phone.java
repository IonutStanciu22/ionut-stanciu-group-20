package edu.scoalainformala.stanciu_ionut_group_20.homework4;

public interface Phone {
    void createContact(String phoneNumber, String firstName, String lastName);
    void viewContacts();
    void sendMessage(String phoneNumber, String messageContent);
    void viewMessages(String phoneNumber);
    void makeCall(String phoneNumber);
    void viewCallHistory();
}
