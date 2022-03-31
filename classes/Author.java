package classes;

public class Author implements Comparable<Author> {
    private String name;
    private String nationality;

    public Author(String name, String nationality) {
        this.name = name;
        this.nationality = nationality;
    }

    public Author() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return "{ " +
                "name: '" + name + '\'' +
                ", nationality: '" + nationality + '\'' +
                "}";
    }

    @Override
    public int compareTo(Author o) {
        return this.getName().compareTo(o.getName());
    }
}
