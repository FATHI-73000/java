package game;

public class WeaponCell extends Cell {
    public WeaponCell(int position) {
        super(position);
    }

    @Override
    public String toString() {
        return "Case " + position + " : Vous trouvez une arme puissante.";
    }
}
