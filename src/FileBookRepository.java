import java.util.ArrayList;
import java.util.List;

public class FileBookRepository implements BookRepository {
    private String filename;
    private List<Book> books = new ArrayList<>();

    public FileBookRepository(String filename) {
        this.filename = filename;
    }

    @Override
    public void save(Book book) {
        books.add(book);
    }

    @Override
    public void delete(Book book) {
        books.remove(book);
    }

    @Override
    public List<Book> findAll() {
        return books;
    }

    @Override
    public Book findById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    @Override
    public Book findByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }

    @Override
    public Book findByAuthor(String author) {
        for (Book book : books) {
            if (book.getAuthor().equals(author)) {
                return book;
            }
        }
        return null;
    }

    @Override
    public Book findByReleaseDate(int releaseDate) {
        for (Book book : books) {
            if (book.getReleaseDate() == releaseDate) {
                return book;
            }
        }
        return null;
    }

    @Override
    public Book findByRating(double rating) {
        for (Book book : books) {
            if (book.getRating() == rating) {
                return book;
            }
        }
        return null;
    }

    @Override
    public Book findByGenre(String genre) {
        for (Book book : books) {
            if (book.getGenre().equals(genre)) {
                return book;
            }
        }
        return null;
    }

    @Override
    public void saveToFile() {

    }

    @Override
    public void loadFromFile() {

    }
}
