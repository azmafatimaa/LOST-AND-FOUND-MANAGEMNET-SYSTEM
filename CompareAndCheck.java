package management.lostandfoundsystem;

import java.util.ArrayList;

public class CompareAndCheck {

    static ArrayList<management.lostandfoundsystem.LostItem> lostList = new ArrayList<>();
    static ArrayList<FoundItem> foundList = new ArrayList<>();

    public static String searchMatchForLost(management.lostandfoundsystem.LostItem lost) {

        for (FoundItem found : foundList) {

            if (lost.getName().equalsIgnoreCase(found.getName())) {

                return "Item Found Successfully!\n\n"
                        + "Found At: " + found.getLocation()
                        + "\nContact: " + found.getPhone();
            }
        }

        return "Unfortunately No match found yet.";
    }
    public static String searchMatchForFound(FoundItem found) {

        for (management.lostandfoundsystem.LostItem lost : lostList) {

            if (found.getName().equalsIgnoreCase(lost.getName())) {

                return "Owner Found!\n\n"
                        + "Lost At: " + lost.getLocation()
                        + "\nContact: " + lost.getPhone();
            }
        }

        return "No owner found yet.";
    }
}
