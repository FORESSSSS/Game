public class Battle {
    Hero hero;
    Character monster;
    static int countMoves;

    public Battle(Hero hero, Character monstr) {
        this.hero = hero;
        this.monster = monstr;
    }

    public void startBattle() throws InterruptedException {
        System.out.printf("Битва между %s и %s началась! \n", hero.getName(), monster.getName());
        countMoves = 0;
        Runnable runnable;
        if ((int) (Math.random() * 2) == 1) {
            runnable = () -> {
                round(hero, monster);
            };
        } else {
            runnable = () -> {
                round(monster, hero);
            };
        }
        Thread thread = new Thread(runnable);
        thread.start();
        thread.join(); // блокируем поток main
    }

    private void round(Character player1, Character player2) {
        int forsePlayer1 = player1.attack();
        countMoves += 1;
        System.out.println("---Ход " + countMoves + " ---");
        System.out.println(player1.getName() + " атакует с силой " + forsePlayer1);
        player2.setHealth(player2.getHealth() - forsePlayer1);
        System.out.println(player2.getName() + ": здоровье=" + player2.getHealth());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (player2.getHealth() == 0) {
            if (player1 instanceof Hero) updateHero((Hero) player1, player2);
            System.out.println("----------------------------- \n" +
                    "Победил " + player1.getName());
            System.out.println(player1 + "\n -----------------------------");
            return;
        }
        round(player2, player1);
    }

    private static void updateHero(Hero hero, Character monster)
    {
        hero.setExp(hero.getExp() + monster.getExp()); // забираем опыт соперника
        hero.setGold(hero.getGold() + monster.getGold());  // забираем золото соперника

        if (hero.getExp() >= Math.pow(hero.getLevel(), 2) * 10){
            hero.setLevel(hero.getLevel() + 1);
            hero.setStatPoints(hero.getStatPoints() + hero.getLevel() * 2);
            System.out.println("---------------------------");
            System.out.printf("Вы получили %n уровень \n", hero.getLevel());
        }
    }


}