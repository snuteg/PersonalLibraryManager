import java.util.Scanner;

public class AppMenu {
    private BookService service;
    private Scanner scanner = new Scanner(System.in);
    private InputValidator validator = new InputValidator(scanner);

    public AppMenu(BookService service) {
        this.service = service;
    }

    public void start() {
        service.load();
        boolean runnable = true;

        while (runnable) {
            printMenu();
            int choice = validator.readInt("Выберите пункт меню: ");

            switch (choice) {
                case 1 -> addBook();
                case 2 -> removeBook();
                case 3 -> service.showAllBooks();
                case 4 -> showBookByTitle();
                case 5 -> showBookByAuthor();
                case 6 -> showBookByGenre();
                case 7 -> service.showReadBooks();
                case 8 -> service.showUnreadBooks();
                case 9 -> service.sortByTitle();
                case 10 -> service.sortByReleaseDate();
                case 11 -> service.sortByRating();
                case 0 -> {
                    service.save();
                    System.out.println("Файлы успешно сохранены, выполняется выход.");
                    runnable = false;
                }
                default -> System.out.println("Вы выбрали неверный пункт меню");
            }
        }
    }

    public void printMenu() {
        System.out.println("=======Personal Library Manager=======");
        System.out.println("1. Добавить книгу");
        System.out.println("2. Удалить книгу");
        System.out.println("3. Показать все книги");
        System.out.println("4. Искать книгу по названию");
        System.out.println("5. Искать книгу по автору");
        System.out.println("6. Искать книгу по жанру");
        System.out.println("7. Показать только прочитанные книги");
        System.out.println("8. Показать только непрочитанные книги");
        System.out.println("9. Сортировать книги по названию");
        System.out.println("10. Сортировать книги по году");
        System.out.println("11. Сортировать книги по рейтингу");
        System.out.println("0. Сохранить и выйти");
    }

    public void addBook() {
        System.out.println("Введите название книги:");
        String title = scanner.nextLine();
        System.out.println("Введите автора книги:");
        String author = scanner.nextLine();
        int releaseDate = validator.readInt("Введите дату выхода: ");
        System.out.println("Введите жанр книги:");
        String genre = scanner.nextLine();
        BookStatus status = setStatus();
        double rating = setRating();

        service.add(new Book(title, author, releaseDate, genre, status, rating));
        System.out.println("Книга добавлена");
    }

    public void removeBook() {
        service.showAllBooks();
        int inputId = validator.readInt("Выберите ID: ");

        Book book = service.findById(inputId);

        if (book != null) {
            service.remove(book);
            System.out.println("Книга удалена");
        }
    }

    public void showBookByTitle() {
        service.showAllBooks();
        System.out.println("Введите название книги:");
        String title = scanner.nextLine();

        service.findByTitle(title);
    }

    public void showBookByAuthor() {
        service.showAllBooks();
        System.out.println("Введите автора книги:");
        String author = scanner.nextLine();

        service.findByAuthor(author);
    }

    public void showBookByGenre() {
        service.showAllBooks();
        System.out.println("Введите жанр книги:");
        String genre = scanner.nextLine();

        service.findByGenre(genre);
    }

    public BookStatus setStatus() {
        System.out.println("Список статусов:");
        System.out.println("1. Прочитано");
        System.out.println("2. Не прочитано");
        System.out.println("3. В процессе");

        while (true) {
            int choice = validator.readInt("Выберите пункт меню: ");

            switch (choice) {
                case 1 -> {
                    return BookStatus.READ;
                }
                case 2 -> {
                    return BookStatus.NOT_READ;
                }
                case 3 -> {
                    return BookStatus.IN_PROGRESS;
                }
                default -> System.out.println("Вы выбрали неверный пункт.");
            }
        }
    }

    public double setRating() {
        while (true) {
            double rating = validator.readDouble("Введите рейтинг: ");

            if (rating >= 1.0 && rating <= 10.0) {
                return rating;
            } else System.out.println("Рейтинг не может быть ниже 1.0 и выше 10.0");
        }
    }
}
