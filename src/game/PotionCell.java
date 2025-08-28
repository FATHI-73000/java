package game;

public class PotionCell extends Cell {
    public PotionCell(int position) {
        super(position);
    }

    @Override
    public String toString() {
        return "Case " + position + " : Une potion magique est là.";
    }
}
