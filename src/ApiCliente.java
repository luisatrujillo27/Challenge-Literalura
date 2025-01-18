import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.Gson;

public class ApiCliente {
    public static Book[] fetchBooksFromApi() {
        try {
            // URL de la API (cambia la URL por la que te proporcionen)
            URL url = new URL("https://api.example.com/books");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Leer la respuesta
            InputStreamReader reader = new InputStreamReader(connection.getInputStream());
            Gson gson = new Gson();
            Book[] books = gson.fromJson(reader, Book[].class);
            return books;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
