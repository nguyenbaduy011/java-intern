package Bai3;

import java.util.ArrayList;

public class Owners {
    private String id;
    private String name;
    private String email;
    private static final ArrayList<String> usedIdNumbers = new ArrayList<>();

    public Owners(String id, String name, String email) {
        if (id.length() != 12) {
            throw new IllegalArgumentException("ID " + id + " must be exactly 12 digits.\nPlease check the data");
        }
        if (!id.matches("\\d{12}")) {
            throw new IllegalArgumentException("ID " + id + " number must contain only digits.\nPlease check the data");
        }
        if (usedIdNumbers.contains(id)) {
            throw new IllegalArgumentException("ID " + id + " has been used.\nPlease check the data");
        }
        if (!email.contains("@")) {
            throw new IllegalArgumentException("Invalid email format: " + email + "\nPlease check the data");
        }
        this.id = id;
        this.name = name;
        this.email = email;
        usedIdNumbers.add(id);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return id + ", " + name + ", " + email;
    }
}
