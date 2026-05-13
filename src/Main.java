public class Main {
    public static void main(String[] args) {
        String filename = "books.txt";
        FileBookRepository repository = new FileBookRepository(filename);
        BookService service = new BookService(repository);

        AppMenu app = new AppMenu(service);
        app.start();
    }
}
