package model;

public class Character {
    private int id;
    private String type;
    private String name;
    private int lifePoints;
    private int strength;
    private String offensiveEquipment;
    private String defensiveEquipment;

    public Character(int id, String type, String name, int lifePoints, int strength, String offensiveEquipment, String defensiveEquipment) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.lifePoints = lifePoints;
        this.strength = strength;
        this.offensiveEquipment = offensiveEquipment;
        this.defensiveEquipment = defensiveEquipment;
    }

    public Character(String type, String name, int lifePoints, int strength, String offensiveEquipment, String defensiveEquipment) {
        this(0, type, name, lifePoints, strength, offensiveEquipment, defensiveEquipment);
    }

    // Getters et setters

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getLifePoints() { return lifePoints; }
    public void setLifePoints(int lifePoints) { this.lifePoints = lifePoints; }

    public int getStrength() { return strength; }
    public void setStrength(int strength) { this.strength = strength; }

    public String getOffensiveEquipment() { return offensiveEquipment; }
    public void setOffensiveEquipment(String offensiveEquipment) { this.offensiveEquipment = offensiveEquipment; }

    public String getDefensiveEquipment() { return defensiveEquipment; }
    public void setDefensiveEquipment(String defensiveEquipment) { this.defensiveEquipment = defensiveEquipment; }

    @Override
    public String toString() {
        return "Character{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", lifePoints=" + lifePoints +
                ", strength=" + strength +
                ", offensiveEquipment='" + offensiveEquipment + '\'' +
                ", defensiveEquipment='" + defensiveEquipment + '\'' +
                '}';
    }
}
