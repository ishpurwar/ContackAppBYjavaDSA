package Controller;

import entity.User;
import Service.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Services services=new Services();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Contact Management ---");
            System.out.println("1. Add Contact");
            System.out.println("2. Delete Contact");
            System.out.println("3. View All Contacts");
            System.out.println("4. Search by First Letter");
            System.out.println("5. Search by Name");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter phone number: ");
                    String phone = sc.nextLine();
                    User user = new User(name, phone);
                    services.addContact(user);
                    break;
                case 2:
                    System.out.print("Enter name to delete: ");
                    String deleteName = sc.nextLine();
                    services.deleteContact(deleteName);
                    break;
                case 3:
                    services.viewAllContacts();
                    break;
                case 4:
                    System.out.print("Enter first letter: ");
                    char letter = sc.nextLine().charAt(0);
                    services.searchByFirstLetter(letter);
                    break;
                case 5:
                    System.out.print("Enter name to search: ");
                    String searchName = sc.nextLine();
                    services.searchByName(searchName);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
