package management.lostandfoundsystem;
public class FoundItem extends management.lostandfoundsystem.Item {
    FoundItem(String name, String location, String time, String description, String phone) {
        super(name, location, time, description, phone);
    }

    @Override
    void displayInfo() {
        System.out.println("Name: " + getName());
        System.out.println("Location: " + getLocation());
        System.out.println("Time: " + getTime());
        System.out.println("Description: " + getDescription());
        System.out.println("Phone: " + getPhone());
        System.out.println("Type: " + getType() + " Item");
    }

    @Override
    String getType() {
        return "Found";
    }
}
