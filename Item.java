package management.lostandfoundsystem;
public abstract class Item {

    private String name;
    private String description;
    private String time;
    private String location;
    private String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        if (phone == null || phone.isEmpty() || !phone.matches("\\d{11}")) {
            throw new IllegalArgumentException("Invalid phone number!");
        }
        this.phone = phone;
    }


    abstract void displayInfo();

    abstract String getType();

    Item(String name, String location) {
        setName(name);
        setLocation(location);
    }

    Item(String name, String location, String time, String description, String phone) {
        this(name, location);
        setTime(time);
        setDescription(description);
        setPhone(phone);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty() || !name.matches("[A-Za-z ]+")) {
            throw new IllegalArgumentException("Invalid Name");
        }
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description == null || description.isEmpty()) {
            throw new IllegalArgumentException("Invalid Description");
        }
        this.description = description;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        if (time == null || time.isEmpty()) {
            throw new IllegalArgumentException("Invalid Time");

        }

        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        if (location == null || location.isEmpty()) {
            this.location = "Unknown";
        } else
            this.location = location;
    }
}

