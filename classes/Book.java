package classes;

import java.util.List;

public class Book extends Material {
    private int numberOfPages;

    public Book() {
    }

    public Book(String title, Author author, String category, List<Review> reviews, int numberOfPages) {
        super(title, author, category, reviews);
        this.numberOfPages = numberOfPages;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }
}
