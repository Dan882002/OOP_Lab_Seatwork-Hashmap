import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class BookDA {
    public static HashMap<String, Book> readBookData(String filename) {
        HashMap<String, Book> bookData = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String isbn = parts[0].trim();
                    String title = parts[1].trim();
                    String authorName = parts[2].trim();
                    Book book = new Book();
                    book.setIsbn(isbn);
                    book.setTitle(title);
                    book.setAuthorName(authorName);
                    bookData.put(isbn, book);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return bookData;
    }
}
