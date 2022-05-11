package services;

import entities.Newsletter;
import entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserServices {
    private static UserServices instance = new UserServices();
    private static List<User> usersList = new ArrayList<User>();
    private static List<Newsletter> newslettersList = new ArrayList<>();

    private UserServices() {
    }

    public static UserServices getInstance() {
        return instance;
    }

    public List<Newsletter> getNewslettersList() {
        return newslettersList;
    }

    public void setNewslettersList(List<Newsletter> newslettersList) {
        UserServices.newslettersList = newslettersList;
    }

    public List<User> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<User> usersList) {
        UserServices.usersList = usersList;
    }

    public void registerUser() {
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
        WriteFileServices.save(usersList,"resources/users.csv", User.class, false);
    }

    public void deleteUser() {
        Scanner scanner = new Scanner(System.in);
        boolean found = false;

        System.out.println("Enter the email of the user:");
        String enteredEmail = scanner.nextLine();
        for (User user : usersList) {
            if (enteredEmail.equals(user.getEmail())) {
                usersList.remove(user);
                WriteFileServices.save(usersList,"resources/users.csv", User.class, false);
                found = true;
                break;
            }
        }
        if (found == false) {
            System.out.println("The email you entered does not exist!");
        }

    }

    public void displayUsers() {
        System.out.println("The registered users are: ");
        for (User user : usersList) {
            System.out.println(user);
        }
    }

    public void displayNewsletter(){
        for (Newsletter n : newslettersList){
            System.out.println(n);
        }
    }
}
