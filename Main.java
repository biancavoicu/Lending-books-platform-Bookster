import entities.*;
import services.*;
import java.util.*;

public class Main {

    private static void menu() {
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        // Menu

        do {
            System.out.println("Choose an option:");
            System.out.println("0. Exit");
            System.out.println("1. Register a new user");
            System.out.println("2. Delete a specified user by email");
            System.out.println("3. Display list of users");
            System.out.println("4. Register a new library");
            System.out.println("5. Delete a specified library");
            System.out.println("6. Display list of libraries");
            System.out.println("7. Add a new material in a specified library");
            System.out.println("8. Display list of materials of a specified library");
            System.out.println("9. Delete a specified material of a specified library");
            System.out.println("10. Leave a review on a specified material in a specified library");
            System.out.println("11. Register a new loan");
            System.out.println("12. Display the list of loans");
            System.out.println("13. Display the pieces of newsletter from 2022"); // in order to use streams and lambda

            try {
                option = scanner.nextInt();
                switch (option) {
                    case 0:
                        break;
                    case 1:
                        WriteFileServices.save(Arrays.asList(new Log("Register a new user")),
                                "resources/log.csv", Log.class, true);
                        UserServices.getInstance().registerUser();
                        break;
                    case 2:
                        WriteFileServices.save(Arrays.asList(new Log("Delete a specified user by email")),
                                "resources/log.csv", Log.class, true);
                        UserServices.getInstance().deleteUser();
                        break;
                    case 3:
                        WriteFileServices.save(Arrays.asList(new Log("Display list of users")),
                                "resources/log.csv", Log.class, true);
                        UserServices.getInstance().displayUsers();
                        break;
                    case 4:
                        WriteFileServices.save(Arrays.asList(new Log("Register a new library")),
                                "resources/log.csv", Log.class, true);
                        LibraryServices.getInstance().registerLibrary();
                        break;
                    case 5:
                        WriteFileServices.save(Arrays.asList(new Log("Delete a specified library")),
                                "resources/log.csv", Log.class, true);
                        LibraryServices.getInstance().deleteLibrary();
                        break;
                    case 6:
                        WriteFileServices.save(Arrays.asList(new Log("Display list of libraries")),
                                "resources/log.csv", Log.class, true);
                        LibraryServices.getInstance().displayLibraries();
                        break;
                    case 7:
                        WriteFileServices.save(Arrays.asList(new Log("Add a new material in a specified library")),
                                "resources/log.csv", Log.class, true);
                        LibraryServices.getInstance().addMaterial();
                        break;
                    case 8:
                        WriteFileServices.save(Arrays.asList(new Log("Display list of materials of a specified library")),
                                "resources/log.csv", Log.class, true);
                        LibraryServices.getInstance().printMaterials();
                        break;
                    case 9:
                        WriteFileServices.save(Arrays.asList(new Log("Delete a specified material of a specified library")),
                                "resources/log.csv", Log.class, true);
                        LibraryServices.getInstance().deleteMaterial();
                        break;
                    case 10:
                        WriteFileServices.save(Arrays.asList(new Log("Leave a review on a specified material in a specified library")),
                                "resources/log.csv", Log.class, true);
                        LibraryServices.getInstance().addReview();
                        break;
                    case 11:
                        WriteFileServices.save(Arrays.asList(new Log("Register a new loan")),
                                "resources/log.csv", Log.class, true);
                        LoanServices.getInstance().addLoan();
                        break;
                    case 12:
                        WriteFileServices.save(Arrays.asList(new Log("Display the list of loans")),
                                "resources/log.csv", Log.class, true);
                        LoanServices.getInstance().displayLoans();
                        break;
                    case 13:
                        WriteFileServices.save(Arrays.asList(new Log("Display the pieces of newsletter from 2022")),
                                "resources/log.csv", Log.class, true);
                        UserServices.getInstance().getNewslettersList().stream()
                                .filter(s -> (s.getDate()).charAt(s.getDate().length() - 1) == '2')
                                .forEach(System.out::println);
                }
            } catch (InputMismatchException e) {
                System.out.println("The option must be an integer!");
            }
        } while (option != 0);

    }

    private static void populate() {
        List<User> usersList = ReadFileServices.load("resources/users.csv", User.class);
        List<Author> authorsList = ReadFileServices.load("resources/authors.csv", Author.class);
        List<Library> libraries = new ArrayList<>();

        List<Review> reviews1 = new ArrayList<>();
        List<Review> reviews2 = new ArrayList<>();
        List<Review> reviews3 = new ArrayList<>();
        List<Review> reviews4 = new ArrayList<>();

        Review review1 = new Review("It kept me on the edge of my seat!", usersList.get(1));
        Review review2 = new Review("Truly fascinating!", usersList.get(0));

        reviews1.add(review1);
        reviews2.add(review2);

        List<Material> materialList1 = new ArrayList<>();
        List<Material> materialList2 = new ArrayList<>();
        materialList1.add(new Book("Murder on the Orient Express", authorsList.get(0), "Thriller", reviews1, 256, "Collins Crime Club"));
        materialList1.add(new AudioBook("Atomic Habits", authorsList.get(8), "Psychology", reviews2, 5, "James Clear"));

        Library library1 = new Library("National Library of Romania", "Bulevardul Unirii 22, București 030823",
                "0213126513", "adriana.boruna@bibnat.ro", materialList1);
        libraries.add(library1);
        LibraryServices.getInstance().sortMaterials(library1);

        materialList2.add(new Article("Molecular mechanisms of developmental pathways in neurological disorders", authorsList.get(10), "Pharmacology", reviews3, 210289));
        materialList2.add(new Book("Adams and Victor's Principles of Neurology", authorsList.get(11), "Neurology", reviews4, 1664, "McGraw Hill"));

        Library library2 = new Library("Carol Davila Library", "Bulevardul Eroii Sanitari 8, București 050474",
                "0213180862", "biblioteca@umfcd.ro", materialList2);
        LibraryServices.getInstance().sortMaterials(library2);
        libraries.add(library2);
        LibraryServices.getInstance().setLibraries(libraries);

        UserServices.getInstance().setUsersList(usersList);

        List<Newsletter> newslettersList = ReadFileServices.load("resources/newsletters.csv", Newsletter.class);
        UserServices.getInstance().setNewslettersList(newslettersList);
    }

    public static void main(String[] args) {
        populate();
        menu();
    }
}