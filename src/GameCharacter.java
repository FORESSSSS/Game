public abstract class GameCharacter implements Fighter {
    private String name;
    private int health;
    private int strength;
    private int dexterity;
    private int experience;
    private int gold;

    public GameCharacter(String name) {
        this.name = name;
        this.health = 100;
        this.strength = 10;
        this.dexterity = 5;
        this.experience = 1;
        this.gold = 100;
    }

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

    public void setName(String name) {
        this.name = name;
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
        if (dexterity * 3 > (int) (Math.random() * 100)) {
            return strength;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "GameCharacter{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", strength=" + strength +
                ", dexterity=" + dexterity +
                ", experience=" + experience +
                ", gold=" + gold +
                '}';
    }
}
