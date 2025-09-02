package db;

import model.Character;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {

    // Ajout de allowPublicKeyRetrieval=true pour éviter l'erreur "Public Key Retrieval is not allowed"
    private static final String URL = "jdbc:mysql://localhost:3306/game?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String USER = "root"; // remplace par ton user
    private static final String PASSWORD = "25095609mfs!"; // remplace par ton mot de passe

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Récupérer tous les héros
    public static List<Character> getHeroes() {
        List<Character> heroes = new ArrayList<>();
        String sql = "SELECT * FROM `Character`";  // <-- backticks autour de Character

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Character hero = new Character(
                        rs.getInt("Id"),
                        rs.getString("Type"),
                        rs.getString("Name"),
                        rs.getInt("LifePoints"),
                        rs.getInt("Strength"),
                        rs.getString("OffensiveEquipment"),
                        rs.getString("DefensiveEquipment")
                );
                heroes.add(hero);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return heroes;
    }

    // Ajouter un héros
    public static boolean createHero(Character hero) {
        String sql = "INSERT INTO `Character` (Type, Name, LifePoints, Strength, OffensiveEquipment, DefensiveEquipment) VALUES (?, ?, ?, ?, ?, ?)"; // backticks

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, hero.getType());
            pstmt.setString(2, hero.getName());
            pstmt.setInt(3, hero.getLifePoints());
            pstmt.setInt(4, hero.getStrength());
            pstmt.setString(5, hero.getOffensiveEquipment());
            pstmt.setString(6, hero.getDefensiveEquipment());

            int rows = pstmt.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Modifier un héros complet
    public static boolean editHero(Character hero) {
        String sql = "UPDATE `Character` SET Type=?, Name=?, LifePoints=?, Strength=?, OffensiveEquipment=?, DefensiveEquipment=? WHERE Id=?"; // backticks

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, hero.getType());
            pstmt.setString(2, hero.getName());
            pstmt.setInt(3, hero.getLifePoints());
            pstmt.setInt(4, hero.getStrength());
            pstmt.setString(5, hero.getOffensiveEquipment());
            pstmt.setString(6, hero.getDefensiveEquipment());
            pstmt.setInt(7, hero.getId());

            int rows = pstmt.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Modifier uniquement les points de vie
    public static boolean changeLifePoints(Character hero) {
        String sql = "UPDATE `Character` SET LifePoints=? WHERE Id=?";  // backticks

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, hero.getLifePoints());
            pstmt.setInt(2, hero.getId());

            int rows = pstmt.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
