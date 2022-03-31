import classes.*;
import services.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static services.LibraryServices.libraries;
import static services.UserServices.usersList;

public class Main {
    public static void main(String[] args) {
        // Some objects so the project is not empty at first
        Author agathaChristie = new Author("Agatha Christie", "british");
        Author jamesClear = new Author("James Clear", "american");
        Author nirajKumarJha = new Author("Niraj Kumar Jha", "indian");
        Author allanRopper = new Author("Allan H. Ropper", "american");

        User u1 = new User("Ganciu Teodora", "teo.ganciu17@gmail.com", "0786345890", "Orange");
        usersList.add(u1);
        User u2 = new User("Coman Camelia", "cami.coman28@gmail.com", "0746458903", "Safeco");
        usersList.add(u2);

        List<Review> reviews1 = new ArrayList<Review>();
        List<Review> reviews2 = new ArrayList<Review>();
        List<Review> reviews3 = new ArrayList<Review>();
        List<Review> reviews4 = new ArrayList<Review>();

        Review review1 = new Review("It kept me on the edge of my seat!", u2);
        Review review2 = new Review("Truly fascinating!", u1);

        reviews1.add(review1);
        reviews2.add(review2);

        Book b = new Book("Murder on the Orient Express", agathaChristie, "Thriller", reviews1, 256);
        AudioBook a = new AudioBook("Atomic Habits", jamesClear, "Psychology", reviews2, 5, "James Clear");
        Article art = new Article("Molecular mechanisms of developmental pathways in neurological disorders", nirajKumarJha, "Pharmacology", reviews3, 210289);
        Book b2 = new Book("Adams and Victor's Principles of Neurology", allanRopper, "Neurology", reviews4, 1664);

        List<Material> materialList1 = new ArrayList<Material>();
        List<Material> materialList2 = new ArrayList<Material>();
        materialList1.add(b);
        materialList1.add(a);

        Library library1 = new Library("National Library of Romania", "Bulevardul Unirii 22, București 030823",
                "0213126513", "adriana.boruna@bibnat.ro", materialList1);
        libraries.add(library1);
        LibraryServices.sortMaterials(library1);

        materialList2.add(art);
        materialList2.add(b2);
        Library library2 = new Library("Carol Davila Library", "Bulevardul Eroii Sanitari 8, București 050474",
                "0213180862", "biblioteca@umfcd.ro", materialList2);
        LibraryServices.sortMaterials(library2);
        libraries.add(library2);


        Scanner scanner = new Scanner(System.in);
        int option;
        // Menu
        do {
            System.out.println("Choose an option:");
            System.out.println("0. Exit");
            System.out.println("1. Register a new user");
            System.out.println("2. Delete a specified user by email");
            System.out.println("3. Print list of users");
            System.out.println("4. Register a new library");
            System.out.println("5. Delete a specified library");
            System.out.println("6. Print list of libraries");
            System.out.println("7. Add a new material in a specified library");
            System.out.println("8. Print list of materials of a specified library");
            System.out.println("9. Delete a specified material of a specified library");
            System.out.println("10. Leave a review on a specified material in a specified library");
            System.out.println("11. Register a new loan");
            System.out.println("12. Print the list of loans");


            option = scanner.nextInt();
            switch (option) {
                case 0:
                    break;
                case 1:
                    UserServices.registerUser();
                    break;
                case 2:
                    UserServices.deleteUser();
                    break;
                case 3:
                    UserServices.printUsers();
                    break;
                case 4:
                    LibraryServices.registerLibrary();
                    break;
                case 5:
                    LibraryServices.deleteLibrary();
                    break;
                case 6:
                    LibraryServices.printLibraries();
                    break;
                case 7:
                    LibraryServices.addMaterial();
                    break;
                case 8:
                    LibraryServices.printMaterials();
                    break;
                case 9:
                    LibraryServices.deleteMaterial();
                    break;
                case 10:
                    LibraryServices.addReview();
                    break;
                case 11:
                    LoanServices.addLoan();
                    break;
                case 12:
                    LoanServices.printLoans();
            }
        } while (option != 0);
    }
}
