package equipment;

public class DefensiveEquipment {
    private String name;
    private int defensePower;
    private String type; // "Shield" ou "Potion"

    public DefensiveEquipment(String name, int defensePower, String type) {
        this.name = name;
        this.defensePower = defensePower;
        this.type = type;
    }

    public String getName() { return name; }
    public int getDefensePower() { return defensePower; }
    public String getType() { return type; }

    public void setName(String name) { this.name = name; }
    public void setDefensePower(int defensePower) { this.defensePower = defensePower; }
    public void setType(String type) { this.type = type; }

    public DefensiveEquipment() {

    }

    @Override
    public String toString() {
        return name + " (" + type + ", défense : " + defensePower + ")";
    }
}
