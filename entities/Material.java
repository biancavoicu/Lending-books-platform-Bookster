package entities;

import java.util.Comparator;
import java.util.List;

public class Material implements Comparable<Material> {
    private static int counter = 0;
    private int materialId;
    private String title;
    private Author author;
    private String category;
    private List<Review> reviews;

    public Material(String title, Author author, String category, List<Review> reviews) {
        counter += 1;
        this.materialId = counter;
        this.title = title;
        this.author = author;
        this.category = category;
        this.reviews = reviews;
    }

    public Material() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Review> getReview() {
        return reviews;
    }

    public void setReview(List<Review> reviews) {
        this.reviews = reviews;
    }

    public int getId() {
        return materialId;
    }


    public static Comparator<Material> compareByTitleAndAuthor = Comparator
            .comparing(Material::getTitle)
            .thenComparing(Material::getAuthor);

    @Override
    public String toString() {
        return '\n'+ "{" +
                "materialId: " + materialId + '\n'+
                ", title: '" + title + '\'' + '\n'+
                ", author: " + author + '\n'+
                ", category '" + category + '\'' + '\n'+
                ", reviews " + reviews +
                "}\n";
    }

    @Override
    public int compareTo(Material o) {
        return 0;
    }
}
