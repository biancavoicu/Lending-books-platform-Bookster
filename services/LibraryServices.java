package services;

import entities.*;
import java.util.*;


public class LibraryServices {
    private static LibraryServices instance = new LibraryServices();
    private static List<Library> libraries = new ArrayList<Library>();

    private LibraryServices() {
    }

    public static LibraryServices getInstance() {
        return instance;
    }

    public List<Library> getLibraries() {
        return libraries;
    }

    public void setLibraries(List<Library> libraries) {
        LibraryServices.libraries = libraries;
    }

    public void registerLibrary() {
        Scanner scanner = new Scanner(System.in);
        String name;
        String address;
        String telephone;
        String email;
        List<Material> materials = new ArrayList<Material>();

        System.out.println("Enter the name of the library:");
        name = scanner.nextLine();

        System.out.println("Enter the address of the library:");
        address = scanner.nextLine();

        System.out.println("Enter the telephone number of the library:");
        telephone = scanner.nextLine();

        System.out.println("Enter the email of the library");
        email = scanner.nextLine();

        Library library = new Library(name, address, telephone, email, materials);
        libraries.add(library);
    }


    public void sortMaterials(Library lib) {
        List<Material> mat = lib.getMaterials();
        Collections.sort(mat, Material.compareByTitleAndAuthor);
        lib.setMaterials(mat);
    }


    public void displayLibraries() {
        for (Library lib : libraries) {
            System.out.println(lib);
        }
    }

    public void addMaterial() {
        Scanner scanner = new Scanner(System.in);

        LibraryServices.getInstance().availableLibraries();
        System.out.println("Choose a library you want to add the material by typing the name");
        String libraryName = scanner.nextLine();
        boolean found = false;

        for (Library lib : libraries) {
            if (lib.getName().equals(libraryName)) {
                System.out.println("Enter the type of the material: Book, AudioBook, Article");
                String materialType = scanner.nextLine();
                found = true;
                if (materialType.equals("Book") || materialType.equals("AudioBook") || materialType.equals("Article")) {
                    List<Material> materials = lib.getMaterials();
                    String title;
                    String category;
                    List<Review> reviews = new ArrayList<Review>();
                    String name;
                    String nationality;

                    System.out.println("Enter the title of the material:");
                    title = scanner.nextLine();

                    System.out.println("Enter the name of the author:");
                    name = scanner.nextLine();

                    System.out.println("Enter the nationality of the author:");
                    nationality = scanner.nextLine();

                    System.out.println("Enter the category of the material:");
                    category = scanner.nextLine();


                    Author author = new Author(name, nationality);

                    try {
                        if (materialType.equals("Book")) {
                            System.out.println("Enter the number of pages of the book:");
                            int numberOfPages = scanner.nextInt();

                            System.out.println("Enter the publisher of the book:");
                            String publisher = scanner.nextLine();

                            Book book = new Book(title, author, category, reviews, numberOfPages, publisher);
                            book.setNumberOfPages(numberOfPages);
                            materials.add(book);

                        } else if (materialType.equals("AudioBook")) {
                            System.out.println("Enter the length (integer) of the audiobook:");
                            int length = scanner.nextInt();
                            System.out.println("Enter the voice of the person who narrates the audiobook:");
                            String voice = scanner.nextLine();

                            AudioBook audioBook = new AudioBook(title, author, category, reviews, length, voice);
                            audioBook.setLength(length);
                            audioBook.setVoice(voice);
                            materials.add(audioBook);

                        } else if (materialType.equals("Article")) {
                            System.out.println("Enter the number of pages of the article:");
                            int numberOfPages = scanner.nextInt();

                            Article article = new Article(title, author, category, reviews, numberOfPages);
                            article.setNumberOfPages(numberOfPages);
                            materials.add(article);
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("The number of pages/ length of Audiobook must be integers!");
                    }
                    lib.setMaterials(materials);
                    LibraryServices.getInstance().sortMaterials(lib);
                    break;
                } else System.out.println("The type of material that you entered does not exist!");
            }
        }
        if (found == false)
            System.out.println("The name of the library that you entered does not exist in our data base!");
    }

    public void deleteLibrary() {
        Scanner scanner = new Scanner(System.in);
        LibraryServices.getInstance().availableLibraries();
        System.out.println("Choose the library you want to delete by typing the name:");
        String libraryName = scanner.nextLine();
        boolean found = false;

        for (Library lib : libraries) {
            if (lib.getName().equals(libraryName)) {
                libraries.remove(lib);
                found = true;
                break;
            }
        }
        if (found == false)
            System.out.println("The name of the library that you entered does not exist in our data base!");
    }


    public void printMaterials() {
        Scanner scanner = new Scanner(System.in);
        LibraryServices.getInstance().availableLibraries();
        System.out.println("Choose the library you want to print the materials from, by typing the name:");
        String libraryName = scanner.nextLine();
        boolean found = false;

        for (Library lib : libraries) {
            if (lib.getName().equals(libraryName)) {
                found = true;
                List<Material> materials = lib.getMaterials();
                for (Material mat : materials) {
                    System.out.println(mat);
                }
                break;
            }
        }
        if (found == false)
            System.out.println("The name of the library that you entered does not exist in our data base!");

    }

    public void availableLibraries() {
        System.out.println("The available libraries are:");
        for (Library lib : libraries) {
            System.out.println(lib.getName());
        }
    }

    public void deleteMaterial() {
        Scanner scanner = new Scanner(System.in);
        LibraryServices.getInstance().availableLibraries();
        System.out.println("Choose the library you want to delete the material from, by typing the name:");
        String libraryName = scanner.nextLine();
        boolean found = false;
        List<Material> materials = new ArrayList<Material>();

        for (Library lib : libraries) {
            if (lib.getName().equals(libraryName)) {
                found = true;
                materials = lib.getMaterials();
            }
        }
        if (found == false)
            System.out.println("The name of the library that you entered does not exist in our data base!");
        else {
            System.out.println("The available materials are:");
            for (Material mat : materials) {
                System.out.println(mat);
            }
            try {
                System.out.println("Choose the material you want to delete by typing the id:");
                int materialId = scanner.nextInt();
                boolean foundId = false;
                for (Material mat : materials) {
                    if (mat.getId() == materialId) {
                        materials.remove(mat);
                        foundId = true;
                        break;
                    }
                }
                if (foundId == false) System.out.println("The id you entered does not exist!");
            } catch (InputMismatchException e) {
                System.out.println("The id must be an integer!");
            }
        }

    }

    public void addReview() {
        Scanner scanner = new Scanner(System.in);
        List<User> usersList = UserServices.getInstance().getUsersList();
        LibraryServices.getInstance().availableLibraries();
        System.out.println("Choose the library you want to choose the material from, by typing the name:");
        String libraryName = scanner.nextLine();
        boolean found = false;
        List<Material> materials = new ArrayList<Material>();
        for (Library lib : libraries) {
            if (lib.getName().equals(libraryName)) {
                materials = lib.getMaterials();
                found = true;
            }
        }
        if (found == true) {
            System.out.println("The available materials are:");
            for (Material mat : materials) {
                System.out.println(mat);
            }
            try {
                System.out.println("Choose the material you want to add a review to by typing the id:");
                int materialId = scanner.nextInt();
                scanner.nextLine();
                boolean foundId = false;
                boolean foundEmail = false;

                for (Material mat : materials) {
                    if (mat.getId() == materialId) {
                        foundId = true;
                        System.out.println("Enter your user email address in order to leave a review:");
                        String enteredEmail = scanner.nextLine();
                        List<Review> reviews = mat.getReview();
                        for (User user : usersList) {
                            if (enteredEmail.equals(user.getEmail())) {
                                System.out.println("Enter the review:");
                                String review = scanner.nextLine();
                                foundEmail = true;
                                User u = user;
                                Review r = new Review(review, u);
                                reviews.add(r);

                                mat.setReview(reviews);
                                break;
                            }
                        }
                        break;
                    }
                }
                if (foundId == false) System.out.println("The id you entered does not exist!");
                else if (foundEmail == false) System.out.println("The email you entered is not registered!");

            } catch (InputMismatchException e) {
                System.out.println("The id must be an integer!");
            }
        } else System.out.println("The name of the library that you entered does not exist in our data base!");
    }


}
