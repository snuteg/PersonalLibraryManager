import java.util.Collections;
import java.util.Comparator;

public class BookService {
    private FileBookRepository repository;

    public BookService(FileBookRepository repository) {
        this.repository = repository;
    }

    public void add(Book book) {
        repository.save(book);
    }

    public void remove(Book book) {
        repository.delete(book);
    }

    public void showAllBooks() {
        if (repository.findAll().isEmpty()) {
            System.out.println("Список книг пуст");
            return;
        }

        for (Book book : repository.findAll()) {
            System.out.println(book);
        }
    }

    public void showReadBooks() {
        if (repository.findAll().isEmpty()) {
            System.out.println("Список книг пуст");
            return;
        }

        for (Book book : repository.findAll()) {
            if (book.getStatus() == BookStatus.READ) {
                System.out.println(book);
            }
        }
    }

    public void showUnreadBooks() {
        if (repository.findAll().isEmpty()) {
            System.out.println("Список книг пуст");
            return;
        }

        for (Book book : repository.findAll()) {
            if (book.getStatus() == BookStatus.NOT_READ) {
                System.out.println(book);
            }
        }
    }

    public void findByTitle(String title) {
        if (repository.findAll().isEmpty()) {
            System.out.println("Список книг пуст");
            return;
        }

        for (Book book : repository.findAll()) {
            if (book.getTitle().equals(title)) {
                System.out.println(book);
            }
        }
    }

    public void findByAuthor(String author) {
        if (repository.findAll().isEmpty()) {
            System.out.println("Список книг пуст");
            return;
        }

        for (Book book : repository.findAll()) {
            if (book.getAuthor().equals(author)) {
                System.out.println(book);
            }
        }
    }

    public void findByGenre(String genre) {
        if (repository.findAll().isEmpty()) {
            System.out.println("Список книг пуст");
            return;
        }

        for (Book book : repository.findAll()) {
            if (book.getGenre().equals(genre)) {
                System.out.println(book);
            }
        }
    }

    public void sortByTitle() {
        if (repository.findAll().isEmpty()) {
            System.out.println("Список книг пуст");
            return;
        }

        repository.findAll().sort(Comparator.comparing(Book::getTitle));

        for (Book book : repository.findAll()) {
            System.out.println(book);
        }
    }

    public void sortByReleaseDate() {
        if (repository.findAll().isEmpty()) {
            System.out.println("Список книг пуст");
            return;
        }

        Collections.sort(repository.findAll());

        for (Book book : repository.findAll()) {
            System.out.println(book);
        }
    }

    public void sortByRating() {
        if (repository.findAll().isEmpty()) {
            System.out.println("Список книг пуст");
            return;
        }

        repository.findAll().sort(Comparator.comparing(Book::getRating));

        for (Book book : repository.findAll()) {
            System.out.println(book);
        }
    }
}
