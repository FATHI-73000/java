package equipment;

public abstract class DefensiveEquipement {
    protected String name;
    protected int defensePower;

    public DefensiveEquipement(String name, int defensePower) {
        this.name = name;
        this.defensePower = defensePower;
    }

    public String getName() { return name; }
    public int getDefensePower() { return defensePower; }

    public void setName(String name) { this.name = name; }
    public void setDefensePower(int defensePower) { this.defensePower = defensePower; }

    @Override
    public String toString() {
        return name + " (Défense : " + defensePower + ")";
    }
}
