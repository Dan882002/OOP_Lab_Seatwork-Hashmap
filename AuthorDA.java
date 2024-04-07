import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class AuthorDA {
    public static HashMap<String, Author> readAuthorData(String filename) {
        HashMap<String, Author> authorData = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String authorName = parts[0].trim();
                    String authorBio = parts[1].trim();
                    Author author = new Author();
                    author.setName(authorName);
                    author.setBio(authorBio);
                    authorData.put(authorName, author);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return authorData;
    }
}
