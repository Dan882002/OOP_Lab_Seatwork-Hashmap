import java.util.HashMap;

public class BookReport {
    public static void main(String[] args) {
        HashMap<String, Book> bookData = BookDA.readBookData("C:\\\\Users\\\\admin\\\\IdeaProjects\\\\BookReport\\\\src\\\\Book.csv");
        HashMap<String, Author> authorData = AuthorDA.readAuthorData("C:\\\\Users\\\\admin\\\\IdeaProjects\\\\BookReport\\\\src\\\\Author.csv");

        if (bookData != null && authorData != null) {
            for (String isbn : bookData.keySet()) {
                Book book = bookData.get(isbn);
                String title = book.getTitle();
                String authorName = book.getAuthorName();
                Author author = authorData.get(authorName);
                if (author != null) {
                    System.out.println(isbn + " " + title);
                    System.out.println("\t" + authorName + " - " + author.getBio());
                    System.out.println();
                }
            }
        }
    }
}
