import java.util.Scanner;
import java.util.Set;

public class Player extends GameCharacter {
    private int level;
    private int maxHealth;
    private int statPoints;
    private static Scanner scanner;
    private static String command;

    public Player(String name) {
        super(name);
        this.level = 1;
        this.statPoints = 3;
    }

    public Player(String name, int health, int strength, int dexterity, int experience, int gold) {
        super(name, health, strength, dexterity, experience, gold);
        this.level = 1;
        this.statPoints = 3;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getStatPoints() {
        return statPoints;
    }

    public void setStatPoints(int statPoints) {
        this.statPoints = statPoints;
    }

    @Override
    public int attack() {
        return super.attack() + getExperience();
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public void useStatPoints() {
        int amount;
        while (true) {
            command = this.printStatsMenu();
            switch (command) {
                case "1": {
                    amount = shareStatPoints("сила");
                    this.setStrength(this.getStrength() + amount);
                    statPoints -= amount;
                    System.out.println(this);
                    break;
                }
                case "2": {
                    amount = shareStatPoints("ловкость");
                    this.setDexterity(this.getDexterity() + amount);
                    statPoints -= amount;
                    System.out.println(this);
                    break;
                }
                case "3": {
                    return;
                }
            }
        }
    }

    private String printStatsMenu() {
        while (true) {
            scanner = new Scanner(System.in);
            System.out.print("Вы можете распределить очки усиления:" + "\n" +
                    "1. Увеличить силу" + "\n" +
                    "2. Увеличить ловкость" + "\n" +
                    "3. Вернуться в главное меню \n -> ");
            Set<String> set = Set.of("1", "2", "3");
            command = scanner.next();
            if (set.contains(command)) {
                return command;
            } else System.out.println("Вы не выбрали пункт меню. Попробуйте еще раз");
        }
    }

    private int shareStatPoints(String nameStat) {
        scanner = new Scanner(System.in);
        System.out.print("У Вас " + this.statPoints + " очков усиления. Сколько добавить к " + nameStat + "? -> ");
        command = scanner.nextLine();
        try {
            if (Integer.parseInt(command) <= this.statPoints) {
                return Integer.parseInt(command);
            } else System.out.println("У Вас нет столько очков усиления");
        } catch (NumberFormatException e) {
            System.out.println("Что-то пошло не так");
        }
        return 0;
    }

    @Override
    public String toString() {
        return getName() + ", уровень = " + level +
                ", здоровье = " + getHealth() +
                ", сила = " + getStrength() +
                ", ловкость = " + getDexterity() +
                ", опыт = " + getExperience() +
                ", золото = " + getGold();
    }
}