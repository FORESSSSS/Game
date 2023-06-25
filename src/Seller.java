import java.util.Scanner;
import java.util.Set;

public class Seller {
    private int gold;
    private int healthPotion;
    private Player player;
    private static Scanner scanner;
    private static String command;

    public Seller(Player player) {
        this.player = player;
        this.gold = 1000;
        this.healthPotion = 1000;
    }

    public int getGold() {
        return gold;
    }

    public int getHealthPotion() {
        return healthPotion;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void setHealthPotion(int healthPotion) {
        this.healthPotion = healthPotion;
    }

    private static String printMenu() {
        while (true) {
            scanner = new Scanner(System.in);
            System.out.print("Что Вы хотите сделать? " + "\n" +
                    "1. Купить зелье здоровья" + "\n" +
                    "2. Купить зелье усиления" + "\n" +
                    "3. Покинуть торговца" + "\n" +
                    "-> ");
            Set<String> set = Set.of("1", "2", "3");
            command = scanner.next();
            if (set.contains(command)) {
                return command;
            } else System.out.println("Вы не выбрали пункт меню. Попробуйте еще раз");
        }
    }

    public void sell() {
        while (true) {
            command = printMenu();
            switch (command) {
                case "1": {
                    System.out.println(player.getName() + "\n" +
                            "здоровье = " + player.getHealth() +" "+
                            "золото = " + player.getGold());
                    System.out.print("1 зелье стоит 5 золотых и увеличивает здоровье на 10\n" +
                            "Введите нужное количество -> ");
                    try {
                        int quantity = scanner.nextInt();
                        if (quantity * 5 <= player.getGold()) {
                            player.setGold(player.getGold() - quantity * 5);
                            player.setHealth(player.getHealth() + quantity * 10);
                            System.out.println(player.getName() + "\n" +
                                    "здоровье = " + player.getHealth() +" "+
                                    "золото = " + player.getGold());
                        } else {
                            System.out.println("У Вас недостаточно золота");
                        }
                    } catch (Exception e) {
                        System.out.println("Вы ввели что-то не то!");
                    }
                    break;
                }
                case "2": {
                    System.out.println(player.getName() + "\n" +
                            "очки усиления = " + player.getStatPoints() +" "+
                            "золото = " + player.getGold());
                    System.out.println("1 зелье усиления стоит 5 золотых\n" +
                            "Введите нужное количество -> ");
                    try {
                        int quantity = scanner.nextInt();
                        if (quantity * 5 <= player.getGold()) {
                            player.setGold(player.getGold() - quantity * 5);
                            player.setStatPoints(player.getStatPoints() + quantity);
                            System.out.println(player.getName() + "\n" +
                                    "очки усиления = " + player.getStatPoints() +" "+
                                    "золото = " + player.getGold());
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