public class Dragon extends Monster {
    private static final Dragon instance = new Dragon();

    private Dragon() {
        super("Дракон", 1000, 50, 50, 1000000, 1000000000);
    }

    public static Dragon getInstance() {
        return instance;
    }
}