package game;

public class EnemyCell extends Cell {

    public EnemyCell(int position) {
        super(position);
    }

    @Override
    public String toString() {
        return "Case " + position + " : Un ennemi dangereux vous attend !";
    }
}
