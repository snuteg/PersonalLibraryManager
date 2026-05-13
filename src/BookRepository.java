import java.util.List;

public interface BookRepository {
    void save(Book book);
    void delete(Book book);
    List<Book> findAll();
    Book findByReleaseDate(int releaseDate);
    Book findByRating(double rating);
    void saveToFile();
    void loadFromFile();
}
