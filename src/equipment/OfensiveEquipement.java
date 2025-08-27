package equipment;

public abstract class OfensiveEquipement {
    protected String name;
    protected int attackPower;

    public OfensiveEquipement(String name, int attackPower) {
        this.name = name;
        this.attackPower = attackPower;
    }

    public String getName() { return name; }
    public int getAttackPower() { return attackPower; }

    public void setName(String name) { this.name = name; }
    public void setAttackPower(int attackPower) { this.attackPower = attackPower; }

    @Override
    public String toString() {
        return name + " (attaque : " + attackPower + ")";
    }
}
