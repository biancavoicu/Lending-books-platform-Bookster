package classes;

import java.util.List;

public class Article extends Material{
    private int numberOfPages;

    public Article(String title, Author author, String category, List<Review> reviews, int numberOfPages) {
        super(title, author, category, reviews);
        this.numberOfPages = numberOfPages;
    }

    public Article() {
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }
}
