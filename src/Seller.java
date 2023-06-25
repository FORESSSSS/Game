import java.util.Scanner;
import java.util.Set;

public class Merchant {
    private int gold;
    private int potionForHealth;
    private Hero hero;
    private static Scanner sc;
    private static String choisMenu;

    public Merchant(Hero hero) {
        this.hero = hero;
        this.gold = 1000;
        this.potionForHealth = 1000;
    }

    public int getGold() {
        return gold;
    }

    public int getPotionForHealth() {
        return potionForHealth;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void setPotionForHealth(int potionForHealth) {
        this.potionForHealth = potionForHealth;
    }

    private static String menu() {
        while (true) {
            sc = new Scanner(System.in);
            System.out.print("Что вы хотите ? " + "\n" +
                    "1. Купить зелье для здоровья" + "\n" +
                    "2. Купить StartPoints" + "\n" +
                    "3. Покинуть торговца" + "\n" +
                    "-> ");
            Set<String> set = Set.of("1", "2", "3");
            choisMenu = sc.next();
            if (set.contains(choisMenu)) {
                return choisMenu;
            } else System.out.println("Вы не выбрали пункт меню. Попробуйте еще раз");
        }
    }

    public void sell() {
        while (true) {
            choisMenu = menu();
            switch (choisMenu) {
                case "1": {
                    System.out.println(hero.getName() + "\n" +
                            " здоровье= " + hero.getHealth() +
                            " золото= " + hero.getGold());
                    System.out.print("1 бутылек зелья стоит 5 золотых и увеличивает здоровье на 10hp \n" +
                            "Введите кол-во бутыльков -> ");
                    try {
                        int quantity = sc.nextInt();
                        if (quantity * 5 <= hero.getGold()) {
                            hero.setGold(hero.getGold() - quantity * 5);
                            hero.setHealth(hero.getHealth() + quantity * 10);
                            System.out.println(hero.getName() + "\n" +
                                    " здоровье= " + hero.getHealth() +
                                    " золото= " + hero.getGold());
                        } else {
                            System.out.println("У вас недостаточно золота");
                        }
                    } catch (Exception e) {
                        System.out.println("Вы ввели что-то не то ");
                    }
                    break;
                }

                case "2": {
                    System.out.println(hero.getName() + "\n" +
                            " StartPoints= " + hero.getStatPoints() +
                            " золото= " + hero.getGold());
                    System.out.println("1 StartPoints стоит 5 золотых. Введите кол-во StartPoints -> ");

                    try {
                        int quantity = sc.nextInt();
                        if (quantity * 5 <= hero.getGold()) {
                            hero.setGold(hero.getGold() - quantity * 5);
                            hero.setStatPoints(hero.getStatPoints() + quantity);
                            System.out.println(hero.getName() + "\n" +
                                    " StatPoints= " + hero.getStatPoints() +
                                    " золото= " + hero.getGold());
                        } else {
                            System.out.println("У вас недостаточно золота");
                        }
                    } catch (Exception e) {
                        System.out.println("Вы ввели что-то не то ");
                    }
                    break;
                }

                case "3": {
                    System.out.println("Пока, пока");
                    return;
                }
            }
        }


    }

}