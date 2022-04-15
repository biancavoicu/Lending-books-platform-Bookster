package services;

import entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserServices {
    private static List<User> usersList = new ArrayList<User>();

    public static List<User> getUsersList() {
        return usersList;
    }

    public static void setUsersList(List<User> usersList) {
        UserServices.usersList = usersList;
    }

    public static void registerUser() {
        Scanner scanner = new Scanner(System.in);
        String name;
        String email;
        String telephone;
        String companyName;

        System.out.println("Enter the name of the user:");
        name = scanner.nextLine();

        System.out.println("Enter the email of the user:");
        email = scanner.nextLine();

        System.out.println("Enter the telephone number of the user:");
        telephone = scanner.nextLine();

        System.out.println("Enter the name of the company the user works for:");
        companyName = scanner.nextLine();

        User user = new User(name, email, telephone, companyName);
        usersList.add(user);
    }

    public static void deleteUser() {
        Scanner scanner = new Scanner(System.in);
        boolean found = false;

        System.out.println("Enter the email of the user:");
        String enteredEmail = scanner.nextLine();
        for (User user : usersList) {
            if (enteredEmail.equals(user.getEmail())) {
                usersList.remove(user);
                found = true;
                break;
            }
        }
        if (found == false) {
            System.out.println("The email you entered does not exist!");
        }

    }

    public static void displayUsers() {
        System.out.println("The registered users are: ");
        for (User user : usersList) {
            System.out.println(user);
        }
    }
}
