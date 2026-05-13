public class Book implements Comparable<Book> {
    private String title;
    private String author;
    private int releaseDate;
    private String genre;
    private double rating;
    private BookStatus status;
    private int id;

    public Book(String title, String author, int releaseDate, String genre, BookStatus status, double rating) {
        this.title = title;
        this.author = author;
        this.releaseDate = releaseDate;
        this.genre = genre;
        this.status = status;
        this.rating = rating;
    }

    public void setId(int id) {this.id = id;}
    public void setStatus(BookStatus status) {this.status = status;}
    private void setRating(double rating) {this.rating = rating;}

    public String getTitle() {return title;}
    public String getAuthor() {return author;}
    public int getReleaseDate() {return releaseDate;}
    public String getGenre() {return genre;}
    public double getRating() {return rating;}
    public BookStatus getStatus() {return status;}
    public int getId() {return id;}

    public String forFileString() {
        return title + ";" + author + ";" + releaseDate + ";" + genre + ";" + status + ";" + rating;
    }

    @Override
    public String toString() {
        return "Book title: " + title
                + " | Author: " + author
                + " | Release Date: " + releaseDate
                + " | Genre: " + genre
                + " | Status: " + status
                + " | Rating: " + rating;
    }

    @Override
    public int compareTo(Book other) {
        return Integer.compare(releaseDate, other.releaseDate);
    }
}
