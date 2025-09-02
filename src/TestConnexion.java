import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnexion {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/game"; // game = nom de ta BDD
        String user = "root"; // ou ton propre utilisateur
        String password = "25095609mfs!"; // remplace par ton mot de passe

        try {

            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("✅ Connexion réussie !");
            conn.close();
        } catch (SQLException e) {
            System.out.println("❌ Erreur de connexion :");
            e.printStackTrace();
        }
    }
}
