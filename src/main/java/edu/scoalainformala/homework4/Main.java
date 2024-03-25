package edu.scoalainformala.homework4;

public class Main {
    public static void main(String[] args) {

        Samsung samsungGalaxyS6 = new Samsung("Black", "Metal", "123456789", 50);
        Samsung samsungGalaxyS22 = new Samsung("White", "Titan", "654321751", 89);

        samsungGalaxyS6.createContact("0761654512", "Ionut", "Stanciu");
        samsungGalaxyS6.createContact("0761665212", "Andrei", "Popescu");

        samsungGalaxyS22.createContact("0790654512", "Cosmin", "Stanciu");
        samsungGalaxyS22.createContact("0780665212", "Gabriel", "Popescu");

        System.out.println();
        samsungGalaxyS6.viewContacts();
        System.out.println();
        samsungGalaxyS22.viewContacts();
        System.out.println();

        samsungGalaxyS6.sendMessage("0780665212", "Hi, how are you?");


        samsungGalaxyS22.makeCall("0761665212");


        samsungGalaxyS22.viewCallHistory();
        System.out.println();
        samsungGalaxyS6.viewMessages("0761665212");


    }
}