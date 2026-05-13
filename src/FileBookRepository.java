import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileBookRepository implements BookRepository {
    private String filename;
    private List<Book> books = new ArrayList<>();
    private int nextId = 1;

    public FileBookRepository(String filename) {
        this.filename = filename;
    }

    @Override
    public void save(Book book) {
        book.setId(nextId++);
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

    public void setBooks(List<Book> newBooks) {
        books.clear();
        books.addAll(newBooks);

        int maxId = 0;
        for (Book book : books) {
            if (book.getId() > maxId) {
                maxId = book.getId();
            }
        }

        nextId = maxId + 1;
    }

    @Override
    public void saveToFile() {
        StringBuilder lines = new StringBuilder();

        for (Book book : books) {
            lines.append(book.forFileString());
        }

        try {
            Files.writeString(Path.of(filename), lines);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void loadFromFile() {
        Book book;
        List<Book> newBooks = new ArrayList<>();

        try {
            String lines = Files.readString(Path.of(filename));
            String[] parts = lines.split("\n");

            for (String part : parts) {
                String[] splitParts = part.split(";");
                String title = splitParts[0];
                String author = splitParts[1];
                int releaseDate = Integer.parseInt(splitParts[2]);
                String genre = splitParts[3];
                BookStatus status = BookStatus.valueOf(splitParts[4]);
                double rating = Double.parseDouble(splitParts[5]);
                book = new Book(title, author, releaseDate, genre, status, rating);
                newBooks.add(book);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        setBooks(newBooks);
    }
}
