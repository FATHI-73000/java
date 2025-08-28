package game;

public abstract class Cell {
    protected int position;

    public Cell(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public abstract String toString();
}
