package test;

import db.DatabaseManager;
import model.Board;
import model.Cell;
import model.Character;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestBoard {

    public static void main(String[] args) {
        // 1️⃣ Créer un board
        Board board = new Board("Board1", 3, 3); // 3x3
        createBoard(board);

        // 2️⃣ Remplir toutes les cellules avec un personnage et un item
        if (board.getId() > 0) {
            for (int row = 0; row < board.getRows(); row++) {
                for (int col = 0; col < board.getColumns(); col++) {
                    Cell cell = new Cell(board.getId(), row, col, "Occupied");
                    createCell(cell);

                    // Créer un personnage pour chaque cellule
                    Character character = new Character(
                            row * board.getColumns() + col + 1, // Id unique
                            "Character" + (row * board.getColumns() + col + 1), // Nom
                            (row + col) % 2 == 0 ? "Hero" : "Enemy", // Type
                            100, // LifePoints
                            10,  // Strength
                            "Weapon" + (row + col), // OffensiveEquipment
                            "Armor" + (row + col)   // DefensiveEquipment
                    );
                    addCharacterToCell(cell, character);

                    // Ajouter un item pour chaque cellule
                    addItemToCell(cell, "Item" + (row + col));
                }
            }

            // 3️⃣ Afficher le board avec détails
            printBoardWithDetails(board.getId());
        } else {
            System.err.println(" Échec de la création du board.");
        }
    }

    private static void createBoard(Board board) {
        String sql = "INSERT INTO Board (Name, `Rows`, `Columns`) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, board.getName());
            pstmt.setInt(2, board.getRows());
            pstmt.setInt(3, board.getColumns());
            pstmt.executeUpdate();

            try (ResultSet rs = pstmt.getGeneratedKeys()) {
                if (rs.next()) {
                    board.setId(rs.getInt(1));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createCell(Cell cell) {
        String sql = "INSERT INTO Cell (BoardId, RowIndex, ColIndex, Content) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            pstmt.setInt(1, cell.getBoardId());
            pstmt.setInt(2, cell.getRowIndex());
            pstmt.setInt(3, cell.getColIndex());
            pstmt.setString(4, cell.getContent());
            pstmt.executeUpdate();

            try (ResultSet rs = pstmt.getGeneratedKeys()) {
                if (rs.next()) {
                    cell.setId(rs.getInt(1));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void addCharacterToCell(Cell cell, Character character) {
        String sql = "UPDATE Cell SET CharacterId = ? WHERE Id = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, character.getId());
            pstmt.setInt(2, cell.getId());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void addItemToCell(Cell cell, String item) {
        String sql = "UPDATE Cell SET Item = ? WHERE Id = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, item);
            pstmt.setInt(2, cell.getId());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void printBoardWithDetails(int boardId) {
        String sql = "SELECT c.RowIndex, c.ColIndex, c.Content, c.Item, ch.CharacterName AS CharacterName " +
                "FROM Cell c LEFT JOIN `Character` ch ON c.CharacterId = ch.Id " +
                "WHERE c.BoardId = ? ORDER BY c.RowIndex, c.ColIndex";

        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, boardId);

            try (ResultSet rs = pstmt.executeQuery()) {
                int currentRow = -1;
                while (rs.next()) {
                    int row = rs.getInt("RowIndex");
                    int col = rs.getInt("ColIndex");
                    String content = rs.getString("Content");
                    String item = rs.getString("Item");
                    String characterName = rs.getString("CharacterName");

                    if (row != currentRow) {
                        if (currentRow != -1) System.out.println();
                        currentRow = row;
                    }

                    String cellDesc = content + ", " + characterName + ", " + item;
                    System.out.print("[" + cellDesc + "]\t");
                }
                System.out.println();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
