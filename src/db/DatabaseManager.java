package db;

import model.Character;
import model.Board;
import model.Cell;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {

    private static final String URL = "jdbc:mysql://localhost:3306/my_app?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String USER = "root";
    private static final String PASSWORD = "25095609mfs!";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // ------------------- Character -------------------

    private static Character mapResultSetToCharacter(ResultSet rs) throws SQLException {
        return new Character(
                rs.getInt("Id"),
                rs.getString("Type"),
                rs.getString("CharacterName"),  // ici CharacterName
                rs.getInt("LifePoints"),
                rs.getInt("Strength"),
                rs.getString("OffensiveEquipment"),
                rs.getString("DefensiveEquipment")
        );
    }

    public static List<Character> getHeroes() {
        List<Character> heroes = new ArrayList<>();
        String sql = "SELECT * FROM `Character`";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                heroes.add(mapResultSetToCharacter(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return heroes;
    }

    public static boolean createHero(Character hero) {
        String sql = "INSERT INTO `Character` (Type, CharacterName, LifePoints, Strength, OffensiveEquipment, DefensiveEquipment) VALUES (?, ?, ?, ?, ?, ?)";
        return executeUpdate(hero, sql, false);
    }

    public static boolean editHero(Character hero) {
        String sql = "UPDATE `Character` SET Type=?, CharacterName=?, LifePoints=?, Strength=?, OffensiveEquipment=?, DefensiveEquipment=? WHERE Id=?";
        return executeUpdate(hero, sql, true);
    }

    public static boolean changeLifePoints(Character hero) {
        String sql = "UPDATE `Character` SET LifePoints=? WHERE Id=?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, hero.getLifePoints());
            pstmt.setInt(2, hero.getId());

            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static boolean executeUpdate(Character hero, String sql, boolean hasId) {
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, hero.getType());
            pstmt.setString(2, hero.getName());  // getName() côté Java reste identique
            pstmt.setInt(3, hero.getLifePoints());
            pstmt.setInt(4, hero.getStrength());
            pstmt.setString(5, hero.getOffensiveEquipment());
            pstmt.setString(6, hero.getDefensiveEquipment());

            if (hasId) {
                pstmt.setInt(7, hero.getId());
            }

            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // ------------------- Board -------------------

    public static boolean createBoard(Board board) {
        String sql = "INSERT INTO Board (Name, RowsCount, ColumnsCount) VALUES (?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, board.getName());
            pstmt.setInt(2, board.getRows());
            pstmt.setInt(3, board.getColumns());

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        board.setId(rs.getInt(1));
                    }
                }
            }
            return affectedRows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static List<Board> getBoards() {
        List<Board> boards = new ArrayList<>();
        String sql = "SELECT * FROM Board";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                boards.add(new Board(
                        rs.getInt("Id"),
                        rs.getString("Name"),
                        rs.getInt("RowsCount"),
                        rs.getInt("ColumnsCount")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return boards;
    }

    // ------------------- Cell -------------------

    public static boolean createCell(Cell cell) {
        String sql = "INSERT INTO Cell (BoardId, RowIndex, ColIndex, Content) VALUES (?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setInt(1, cell.getBoardId());
            pstmt.setInt(2, cell.getRowIndex());
            pstmt.setInt(3, cell.getColIndex());
            pstmt.setString(4, cell.getContent());

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        cell.setId(rs.getInt(1));
                    }
                }
            }
            return affectedRows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static List<Cell> getCellsByBoard(int boardId) {
        List<Cell> cells = new ArrayList<>();
        String sql = "SELECT * FROM Cell WHERE BoardId = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, boardId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    cells.add(new Cell(
                            rs.getInt("Id"),
                            rs.getInt("BoardId"),
                            rs.getInt("RowIndex"),
                            rs.getInt("ColIndex"),
                            rs.getString("Content")
                    ));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cells;
    }
}
