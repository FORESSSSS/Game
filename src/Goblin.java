public class Goblin extends Monster {
    static Player player;
    public Goblin(String name) {
        super(name, 100, 10, 25, 7, ((int) (Math.random() * 50)));
    }
}