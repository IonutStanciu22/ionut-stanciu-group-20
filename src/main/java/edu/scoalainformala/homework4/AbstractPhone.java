package edu.scoalainformala.homework4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractPhone implements Phone {
    protected String color;
    protected String material;
    protected String IMEI;
    protected int batteryLife;
    protected Map<String, Contact> contacts;
    protected List<Message> messagesSent;
    protected List<Call> callHistory;

    public AbstractPhone(String color, String material, String IMEI, int batteryLife) {
        this.color = color;
        this.material = material;
        this.IMEI = IMEI;
        this.batteryLife = batteryLife;
        this.contacts = new HashMap<>();
        this.messagesSent = new ArrayList<>();
        this.callHistory = new ArrayList<>();
    }

    @Override
    public void createContact(String phoneNumber, String firstName, String lastName) {
        Contact contact = new Contact(phoneNumber, firstName, lastName);
        contacts.put(phoneNumber, contact);
        System.out.println("Contact created successfully.");
    }

    @Override
    public void viewContacts() {
        System.out.println("Contacts:");
        for (Map.Entry<String, Contact> entry : contacts.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().getFirstName() + " " + entry.getValue().getLastName());
        }
    }

    @Override
    public void sendMessage(String phoneNumber, String messageContent) {
        if (!contacts.containsKey(phoneNumber)) {
            System.out.println("Contact does not exist.");
            return;
        }
        if (messageContent.length() > 100) {
            System.out.println("Message exceeds 100 characters.");
            return;
        }
        reduceBatteryLife(1);
        Message message = new Message(IMEI, phoneNumber, messageContent);
        messagesSent.add(message);
        System.out.println("Message sent successfully.");
    }

    @Override
    public void viewMessages(String phoneNumber) {
        System.out.println("Messages for " + phoneNumber + ":");
        for (Message message : messagesSent) {
            if (message.getReceiver().equals(phoneNumber)) {
                System.out.println("From: " + message.getSender() + ", Content: " + message.getContent());
            }
        }
    }

    @Override
    public void makeCall(String phoneNumber) {
        if (!contacts.containsKey(phoneNumber)) {
            System.out.println("Contact does not exist.");
            return;
        }
        reduceBatteryLife(2);
        Call call = new Call(phoneNumber);
        callHistory.add(call);
        System.out.println("Call made successfully.");
    }

    @Override
    public void viewCallHistory() {
        System.out.println("Call History:");
        for (Call call : callHistory) {
            System.out.println("To: " + call.getReceiver() + ", Duration: " + call.getDuration());
        }
    }

    // Helper method to reduce battery life
    protected void reduceBatteryLife(int hours) {
        batteryLife -= hours;
    }
}
