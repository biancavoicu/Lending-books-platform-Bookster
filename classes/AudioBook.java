package classes;

import java.util.List;

public class AudioBook extends Material{
    private int length;
    private String voice;

    public AudioBook(String title, Author author, String category, List<Review> reviews, int length, String voice) {
        super(title, author, category, reviews);
        this.length = length;
        this.voice = voice;
    }

    public AudioBook() {
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getVoice() {
        return voice;
    }

    public void setVoice(String voice) {
        this.voice = voice;
    }
}
