import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Kata5P1 {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:Kata5.db";
        String sql = "SELECT * FROM PEOPLE";
        Connection conn;
        try {
            conn = DriverManager.getConnection(url);
            System.out.println("Conexión establecida con Kata5.bd");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getInt("id") + "\t" +
                    rs.getString("Name") + "\t" +
                    rs.getString("Apellidos") + "\t" +
                    rs.getString("Departamento") + "\t");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}