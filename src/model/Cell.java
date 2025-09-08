package model;

// ------------------- Cell -------------------
public class Cell {
    private int id;
    private int boardId;
    private int rowIndex;
    private int colIndex;
    private String content;

    // Constructeur complet
    public Cell(int id, int boardId, int rowIndex, int colIndex, String content) {
        this.id = id;
        this.boardId = boardId;
        this.rowIndex = rowIndex;
        this.colIndex = colIndex;
        this.content = content;
    }

    // Constructeur sans id (pour insertion)
    public Cell(int boardId, int rowIndex, int colIndex, String content) {
        this.boardId = boardId;
        this.rowIndex = rowIndex;
        this.colIndex = colIndex;
        this.content = content;
    }

    // Getters et setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getBoardId() { return boardId; }
    public void setBoardId(int boardId) { this.boardId = boardId; }

    public int getRowIndex() { return rowIndex; }
    public void setRowIndex(int rowIndex) { this.rowIndex = rowIndex; }

    public int getColIndex() { return colIndex; }
    public void setColIndex(int colIndex) { this.colIndex = colIndex; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
}
