public class Dragon extends Monster {
    private static final Dragon instance = new Dragon();

    private Dragon() {
        super("Дракон", 800, 50, 50, 1000000, ((int) (Math.random() * 1000000000)));
    }

    public static Dragon getInstance() {
        return instance;
    }
}