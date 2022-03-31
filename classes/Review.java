package classes;

public class Review {
    private String content;
    private User user;

    public Review(String content, User user) {
        this.content = content;
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return '\n'+ "Review{" +
                "content: '" + content + '\'' + '\n'+
                ", user: " + user +
                "}\n";
    }
}
