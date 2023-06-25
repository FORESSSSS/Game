import java.util.Scanner;
import java.util.Set;

public class Seller {
    private Player player;
    private static Scanner scanner;
    private static String command;
    private static int priceHealthPotion = 10;
    private static int priceStatPointsPotion = 50;

    public Seller(Player player) {
        this.player = player;
    }

    public static int getPriceHealthPotion() {
        return priceHealthPotion;
    }

    public static int getPriceStatPointsPotion() {
        return priceStatPointsPotion;
    }

    private static String printMenu() {
        while (true) {
            scanner = new Scanner(System.in);
            System.out.print("Что Вы хотите сделать?\n" +
                    "1. Купить зелье здоровья\n" +
                    "2. Купить зелье усиления\n" +
                    "3. Покинуть торговца\n" +
                    "-> ");
            Set<String> set = Set.of("1", "2", "3");
            command = scanner.next();
            if (set.contains(command)) {
                return command;
            } else System.out.println("Попробуйте еще раз");
        }
    }

    public void sell() {
        while (true) {
            command = printMenu();
            switch (command) {
                case "1": {
                    System.out.println(player.getName() + "\n" +
                            "здоровье: " + player.getHealth() + " из " + player.getMaxHealth() +
                            " золото: " + player.getGold());
                    System.out.print("1 зелье стоит 10 золотых и увеличивает здоровье на 10\n" +
                            "Введите нужное количество -> ");
                    try {
                        int quantity = scanner.nextInt();
                        if (player.getHealth() + (quantity * 10) >= player.getMaxHealth()) {
                            System.out.println("У Вас максимальный уровень здоровья!\n");
                        } else {
                            if (quantity * getPriceHealthPotion() <= player.getGold()) {
                                player.setGold(player.getGold() - quantity * getPriceHealthPotion());
                                player.setHealth(player.getHealth() + quantity * 10);
                                System.out.println(player.getName() + "\n" +
                                        "здоровье: " + player.getHealth() + " из " + player.getMaxHealth() +
                                        " золото: " + player.getGold());
                            } else {
                                System.out.println("У Вас недостаточно золота");
                            }
                        }
                    } catch (Exception e) {
                        System.out.println("Вы ввели что-то не то!");
                    }
                    break;
                }
                case "2": {
                    System.out.println(player.getName() + "\n" +
                            "очки усиления: " + player.getStatPoints() +
                            " золото: " + player.getGold());
                    System.out.println("1 зелье усиления стоит 50 золотых\n" +
                            "Введите нужное количество -> ");
                    try {
                        int quantity = scanner.nextInt();
                        if (quantity * getPriceStatPointsPotion() <= player.getGold()) {
                            player.setGold(player.getGold() - quantity * getPriceStatPointsPotion());
                            player.setStatPoints(player.getStatPoints() + quantity);
                            System.out.println(player.getName() + "\n" +
                                    "очки усиления: " + player.getStatPoints() +
                                    " золото: " + player.getGold());
                        } else {
                            System.out.println("У Вас недостаточно золота");
                        }
                    } catch (Exception e) {
                        System.out.println("Вы ввели что-то не то!");
                    }
                    break;
                }
                case "3": {
                    System.out.println("Досвидания!\n");
                    return;
                }
            }
        }
    }
}