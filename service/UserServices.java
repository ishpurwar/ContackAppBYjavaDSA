package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import entity.User;
import repository.UserDB;

public class UserServices {
     private Map<String, List<User>> db;
    public UserServices(){
        db=UserDB.getUserDatabase();
    }
    public void addContact(User user) {
        String key = user.getName().toLowerCase();
        db.putIfAbsent(key, new ArrayList<>());
        db.get(key).add(user);
        System.out.println("Contact added successfully.");
    }


    public void deleteContact(String name) {
        String key = name.toLowerCase();
        if (db.containsKey(key)) {
            db.remove(key);
            System.out.println("Contact(s) deleted successfully.");
        } else {
            System.out.println("Contact not found.");
        }
    }

    public void viewAllContacts() {
        if (db.isEmpty()) {
            System.out.println("No contacts available.");
            return;
        }
        for (List<User> users : db.values()) {
            for (User user : users) {
                System.out.println(user);
            }
        }
    }

    public void searchByFirstLetter(char firstLetter) {
        boolean found = false;
        for (List<User> users : db.values()) {
            for (User user : users) {
                if (user.getName().toLowerCase().charAt(0) == Character.toLowerCase(firstLetter)) {
                    System.out.println(user);
                    found = true;
                }
            }
        }
        if (!found) {
            System.out.println("No contacts found starting with " + firstLetter);
        }
    }

  
public void searchByName(String partialName) {
    boolean found = false;
    String search = partialName.toLowerCase();

    for (List<User> users : db.values()) {
        for (User user : users) {
            if (user.getName().toLowerCase().contains(search)) {
                System.out.println(user);
                found = true;
            }
        }
    }

    if (!found) {
        System.out.println("No contacts found containing: " + partialName);
    }
}
}
