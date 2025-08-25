package equipment;

public class OfensiveEquipment {
    private String name;
    private int attackPower;
    private String type; // "Weapon" ou "Spell"

    public OfensiveEquipment(String name, int attackPower, String type) {
        this.name = name;
        this.attackPower = attackPower;
        this.type = type;
    }

    public String getName() { return name; }
    public int getAttackPower() { return attackPower; }
    public String getType() { return type; }

    public void setName(String name) { this.name = name; }
    public void setAttackPower(int attackPower) { this.attackPower = attackPower; }
    public void setType(String type) { this.type = type; }

    @Override
    public String toString() {
        return name + " (" + type + ", attaque : " + attackPower + ")";
    }
}
