public class Battle {
    Player player;
    GameCharacter monster;
    static int countMoves;

    public Battle(Player player, GameCharacter monster) {
        this.player = player;
        this.monster = monster;
    }

    public void startBattle() throws InterruptedException {
        System.out.printf("Битва между %s и %s началась!\n", player.getName(), monster.getName());
        countMoves = 0;
        Runnable runnable;
        if ((int) (Math.random() * 2) == 1) {
            runnable = () -> {
                round(player, monster);
            };
        } else {
            runnable = () -> {
                round(monster, player);
            };
        }
        Thread thread = new Thread(runnable);
        thread.start();
        thread.join();
    }

    private void round(GameCharacter player1, GameCharacter player2) {
        int hit = player1.attack();
        countMoves++;
        System.out.println("--- Ход " + countMoves + " ---");
        if (hit == 0) {
            System.out.println("ПРОМАХ!");
        } else {
            if (hit >= (player1.getStrength() * 2)) {
                System.out.println("КРИТ!");
            }
            System.out.println(player1.getName() + " наносит удар " + hit);
            player2.setHealth(player2.getHealth() - hit);
        }
        System.out.println(player2.getName() + ": здоровье " + player2.getHealth());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (player2.getHealth() <= 0) {
            if (player1 instanceof Player) updatePlayer((Player) player1, player2);
            System.out.println("------------------------------\n" +
                    "Победил " + player1.getName());
            System.out.println(player1 + "\n------------------------------");
            return;
        }
        round(player2, player1);
    }

    private static void updatePlayer(Player player, GameCharacter monster) {
        player.setExperience(player.getExperience() + monster.getExperience());
        player.setGold(player.getGold() + monster.getGold());
        if (player.getExperience() >= Math.pow(player.getLevel(), 2) * 10) {
            player.setLevel(player.getLevel() + 1);
            player.setStatPoints(player.getStatPoints() + player.getLevel() * 2);
            player.setMaxHealth(player.getMaxHealth() + 30);
            player.setHealth(player.getMaxHealth());
            System.out.println("------------------------------");
            System.out.printf("Вы получили %d-й уровень!\n", player.getLevel());
            System.out.println("Здоровье восстановилось!");
        }
        if (player.getLevel() == 5) {
            System.out.println("Пришло время сразиться с драконом!");
        }
    }
}