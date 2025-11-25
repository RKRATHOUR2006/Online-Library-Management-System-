import java.io.Serializable;

public class Book implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String title;
    private String author;
    private int totalCopies;
    private int availableCopies;

    public Book(int id, String title, String author, int totalCopies) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.totalCopies = totalCopies;
        this.availableCopies = totalCopies;
    }

    // Getters and setters
    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getTotalCopies() { return totalCopies; }
    public int getAvailableCopies() { return availableCopies; }
    public void setTitle(String title) { this.title = title; }
    public void setAuthor(String author) { this.author = author; }
    public void setTotalCopies(int totalCopies) {
        int issued = this.totalCopies - this.availableCopies;
        this.totalCopies = totalCopies;
        this.availableCopies = Math.max(0, totalCopies - issued);
    }

    public boolean issueOne() {
        if (availableCopies > 0) {
            availableCopies--;
            return true;
        }
        return false;
    }

    public void returnOne() {
        if (availableCopies < totalCopies) {
            availableCopies++;
        }
    }

    @Override
    public String toString() {
        return String.format("Book[id=%d, title=%s, author=%s, total=%d, avail=%d]",
                id, title, author, totalCopies, availableCopies);
    }
}
