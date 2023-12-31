public abstract class GameCharacter implements Fighter {
    private String name;
    private int health;
    private int strength;
    private int dexterity;
    private int experience;
    private int gold;

    public GameCharacter(String name, int health, int strength, int dexterity, int experience, int gold) {
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.dexterity = dexterity;
        this.experience = experience;
        this.gold = gold;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    @Override
    public int attack() {
        int random = (int) (Math.random() * 100);
        if (dexterity * 3 > random) {
            if (random >= 70 && random <= 77) {
                return (getStrength() * 2) + (int) (Math.random() * 10);
            } else {
                return getStrength() + (int) (Math.random() * 10);
            }
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "здоровье: " + health;
    }
}