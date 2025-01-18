import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Database {
    public static void saveBook(Book book) {
        try {
            // Conexión a la base de datos
            Connection conn = DriverManager.getConnection("jdbc:sqlite:literatura.db");

            // Crear la tabla si no existe
            String createTableSQL = "CREATE TABLE IF NOT EXISTS books ("
                    + "isbn TEXT PRIMARY KEY,"
                    + "title TEXT,"
                    + "author TEXT,"
                    + "description TEXT)";
            conn.createStatement().execute(createTableSQL);

            // Insertar libro
            String insertSQL = "INSERT INTO books (isbn, title, author, description) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(insertSQL);
            pstmt.setString(1, book.getIsbn());
            pstmt.setString(2, book.getTitle());
            pstmt.setString(3, book.getAuthor());
            pstmt.setString(4, book.getDescription());
            pstmt.executeUpdate();

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

