
import characters.Warrior;
import characters.Wizard;

public class Main {
    public static void main(String[] args) {
        Warrior arthur = new Warrior("Arthur");
        Wizard merlin = new Wizard("Merlin");

        arthur.presentation();
        merlin.presentation();

        System.out.println(arthur);
        System.out.println(merlin);
    }
}
