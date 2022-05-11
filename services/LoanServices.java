package services;

import entities.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

public class LoanServices {
    private static LoanServices instance = new LoanServices();
    public static List<Loan> loans = new ArrayList<Loan>();

    private LoanServices() {
    }

    public static LoanServices getInstance() {
        return instance;
    }

    public void addLoan() {
        List<Library> libraries = LibraryServices.getInstance().getLibraries();
        List<User> usersList = UserServices.getInstance().getUsersList();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your user email address in order to loan from a library:");
        String enteredEmail = scanner.nextLine();
        User u = new User();

        boolean foundEmail = false;
        boolean foundLibrary = false;

        for (User user : usersList) {
            if (enteredEmail.equals(user.getEmail())) {
                u = user;
                foundEmail = true;
                break;
            }
        }

        if (foundEmail == true) {
            System.out.println("The available libraries are:");
            LibraryServices.getInstance().displayLibraries();
            System.out.println("Choose the library you want to print the materials from, by typing the name:");
            String libraryName = scanner.nextLine();

            List<Material> materials = new ArrayList<Material>();

            for (Library lib : libraries) {
                if (lib.getName().equals(libraryName)) {
                    foundLibrary = true;
                    materials = lib.getMaterials();
                    for (Material mat : materials) {
                        System.out.println(mat);
                    }
                    break;
                }
            }
            if (foundLibrary == true) {

                try {
                    boolean foundId = false;

                    System.out.println("Choose the materials you want to loan by typing the id. When you want to stop, type 0.");
                    int enteredId = scanner.nextInt();

                    List<Material> loanMaterials = new ArrayList<Material>();

                    do {
                        for (Material mat : materials) {
                            if (mat.getId() == enteredId) {
                                foundId = true;
                                loanMaterials.add(mat);
                                break;
                            }
                        }
                        if (foundId == false) {
                            System.out.println("The id you entered does not exist!");
                        }
                        System.out.println("Enter another id:");
                        enteredId = scanner.nextInt();
                        foundId = false;
                    } while (enteredId != 0);

                    Loan l = new Loan(u, loanMaterials);
                    loans.add(l);
                } catch (InputMismatchException e) {
                    System.out.println("The id must be an integer!");
                }
            } else System.out.println("The name of the library that you entered does not exist in our data base!");
        } else System.out.println("The email you entered is not registered!");
    }

    public void displayLoans() {
        for (Loan loan : loans) {
            System.out.println(loan);
        }
    }
}
