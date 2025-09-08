package test;

import characters.Warrior;
import equipment.OfensiveEquipement;
import equipment.Arme;
import equipment.DefensiveEquipement;
import equipment.Bouclier;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.InstanceCreator;
import java.lang.reflect.Type;

public class TestWarrior {

    public static void main(String[] args) {

        // Création d'un Warrior
        Warrior thor = new Warrior("Thor", 10);

        // Gson avec InstanceCreator pour les équipements abstraits
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(OfensiveEquipement.class, new InstanceCreator<OfensiveEquipement>() {
                    @Override
                    public OfensiveEquipement createInstance(Type type) {
                        return new Arme("Épée par défaut", 0); // implémentation concrète
                    }
                })
                .registerTypeAdapter(DefensiveEquipement.class, new InstanceCreator<DefensiveEquipement>() {
                    @Override
                    public DefensiveEquipement createInstance(Type type) {
                        return new Bouclier("Bouclier par défaut", 0); // implémentation concrète
                    }
                })
                .create();

        // Conversion en JSON
        String json = thor.toJson();
        System.out.println("Warrior en JSON :");
        System.out.println(json);

        // Reconstruction depuis le JSON
        Warrior copy = gson.fromJson(json, Warrior.class);
        System.out.println("Warrior reconstruit depuis JSON :");
        copy.presentation();
    }
}
