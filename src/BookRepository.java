import java.util.List;

public interface BookRepository {
    void save(Book book);
    void delete(Book book);
    List<Book> findAll();
    Book findById(int id);
    Book findByTitle(String title);
    Book findByAuthor(String author);
    Book findByReleaseDate(int releaseDate);
    Book findByRating(double rating);
    Book findByGenre(String genre);
    void saveToFile();
    void loadFromFile();
}
