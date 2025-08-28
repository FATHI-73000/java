package game;

public class EmptyCell extends Cell {
    public EmptyCell(int position) {
        super(position);
    }

    @Override
    public String toString() {
        return "Case " + position + " : Case vide";
    }
}
