package model;

// ------------------- Board -------------------
public class Board {
    private int id;
    private String name;
    private int rows;
    private int columns;

    // Constructeur complet
    public Board(int id, String name, int rows, int columns) {
        this.id = id;
        this.name = name;
        this.rows = rows;
        this.columns = columns;
    }

    // Constructeur sans id (pour insertion)
    public Board(String name, int rows, int columns) {
        this.name = name;
        this.rows = rows;
        this.columns = columns;
    }

    // Getters et setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getRows() { return rows; }
    public void setRows(int rows) { this.rows = rows; }

    public int getColumns() { return columns; }
    public void setColumns(int columns) { this.columns = columns; }
}
