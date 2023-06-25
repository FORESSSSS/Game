import java.util.Scanner;
import java.util.Set;

public class Main {
    public static Scanner scanner;
    public static String command;
    public static Player player;
    public static GameCharacter monster;
    public static Seller seller;

    public static void main(String[] args) throws InterruptedException {
        scanner = new Scanner(System.in);
        System.out.print("Введите имя героя: ");
        String heroName = scanner.nextLine();
        player = new Player(heroName, 100, 20, 20, 0, 100);
        System.out.println(player + "\n ---------------------- \n");
        statGame();
    }

    private static String printMenu() {
        while (true) {
            scanner = new Scanner(System.in);
            System.out.print("Куда Вы хотите пойти? " + "\n" +
                    "1. К торговцу" + "\n" +
                    "2. В тёмный лес" + "\n" +
                    "3. Посмотреть состояние героя" + "\n");
            if (player.getStatPoints() > 0) {
                System.out.println("4. Распределить очки усиления");
            }
            System.out.print("Для выхода нажмите Q" + "\n" + "-> ");
            Set<String> set = Set.of("1", "2", "3", "4", "Q");
            command = scanner.next();
            if (set.contains(command)) {
                return command;
            } else {
                System.out.println("Вы не выбрали пункт меню. Попробуйте еще раз");
            }
        }
    }

    private static void statGame() throws InterruptedException {
        while (true) {
            command = printMenu();
            switch (command) {
                case "1": {
                    seller = new Seller(player);
                    seller.sell();
                    break;
                }
                case "2": {
                    if ((int) (Math.random() * 2) == 1) {
                        monster = new Goblin("Гоблин");
                    } else monster = new Skeleton("Скелет");
                    Battle battle = new Battle(player, monster);
                    battle.startBattle();
                    if (player.getHealth() <= 0) {
                        System.out.println("Вы потерпели поражение!");
                        System.out.println("ИГРА ОКОНЧЕНА");
                        System.exit(1);
                    }
                    break;
                }
                case "3": {
                    System.out.println(player);
                    break;
                }
                case "4": {
                    player.useStatPoints();
                    break;
                }
                case "Q": {
                    System.out.println("Вы вышли из игры.");
                    System.exit(1);
                    return;
                }
            }
        }
    }
}