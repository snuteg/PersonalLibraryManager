import java.util.List;

public interface BookRepository {
    void save(Book book);
    void delete(Book book);
    List<Book> findAll();
    void saveToFile();
    void loadFromFile();
}
