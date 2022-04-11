package entities;

import java.util.List;

public class Book extends Material {
    private int numberOfPages;
    private String publisher;

    public Book() {
    }

    public Book(String title, Author author, String category, List<Review> reviews, int numberOfPages, String publisher) {
        super(title, author, category, reviews);
        this.numberOfPages = numberOfPages;
        this.publisher = publisher;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return super.toString() + "Book{" +
                "numberOfPages=" + numberOfPages +
                ", publisher='" + publisher + '\'' +
                '}';
    }
}
