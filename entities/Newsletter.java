package entities;

public class Newsletter {
    private String content;
    private String date;

    public Newsletter(String content, String date) {
        this.content = content;
        this.date = date;
    }

    public Newsletter() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Newsletter's content: \n" + content +
                "\n -> published at the date: " + date +
                '\n';
    }
}
