import java.util.Scanner;
import java.util.Set;

public class Main {
    public static Scanner sc;
    public static String choisMenu;
    public static Hero hero;
    public static Character monster;
    public static Merchant merchant; // продавец

    public static void main(String[] args) throws InterruptedException {

        // создаем героя
        sc = new Scanner(System.in);
        System.out.print("Привет! Введи имя героя: ");
        String heroName = sc.nextLine();
        hero = new Hero(heroName, 5, 100, 11, 2, 100);
        System.out.println(hero + "\n ---------------------- \n");
        statGame();

    }

    private static String menuMain() {
        while (true) {
            sc = new Scanner(System.in);
            System.out.print("Куда вы хотите пойти? " + "\n" +
                    "1. К торговцу" + "\n" +
                    "2. В тёмный лес" + "\n" +
                    "3. Посмотреть состояние героя" + "\n");
            if (hero.getStatPoints() > 0) System.out.println("4. Распределить StatPoints");
            System.out.print("Для выхода нажмите q" + "\n" + "-> ");
            Set<String> set = Set.of("1", "2", "3","4", "q");
            choisMenu = sc.next();
            if (set.contains(choisMenu)) {
                return choisMenu;
            } else System.out.println("Вы не выбрали пункт меню. Попробуйте еще раз");
        }
    }

    private static void statGame() throws InterruptedException {
        while (true) {
            choisMenu = menuMain();
            switch (choisMenu) {
                case "1": {
                    merchant = new Merchant(hero);
                    merchant.sell();
                    //System.out.println("Торговец еще не вышел на работу");
                    break;
                }
                case "2": {
                    // создаем монстра
                    if ((int) (Math.random() * 2) == 1) {
                        monster = new Goblin("Goblin");
                    } else monster = new Skeleton("Skeleton");

                    Battle battle = new Battle(hero, monster);
                    battle.startBattle();
                    if (hero.getHealth() == 0) {
                        System.out.println("Вы потерпели поражение =`(");
                        System.exit(1);
                    }
                    break;
                }
                case "3": {
                    System.out.println(hero);
                    break;

                }case "4": {
                    hero.useStatPoints();
                    break;
                }

                case "q": {
                    System.out.println("Вы вышли из игры.");
                    //System.exit(1);
                    return;
                }
            }
        }
    }

}