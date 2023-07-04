package units.abstractUnits;

public abstract class Unit implements UnitInterface {   //implements AutoCloseable  попробовать?
    private final String name;
    private final UnitsTypes type;
    private int health;
    private int pointActivites;
    private int defense;
    private int speed;
    private int attack;
    private boolean defended;
    private boolean attacked;


    public Unit(int health, int defense, int attack, UnitsTypes type, String name) {
        this.health = 50 + health;
        this.defense = 2 + defense;
        this.attack = 5 + attack;
        speed = 3;
        pointActivites = 1;
        defended = false;
        attacked = false;
        this.name = name;
        this.type = type;
    }

    public Unit(UnitsTypes type, String name) {
        this(0, 0, 0, type, name);
    }

    /**
     * Атака
     *
     * @param target
     */
    public void performAnAttack(Unit target) {
        if (getPointActivites() > 0) {
            if (this.attack - target.getDefense() > 0) {
                target.decreaseHealth(this.attack - target.getDefense());
            }
        }
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type.toString();
    }

    public void skipAMove() {
        pointActivites = 0;
    }

    public void skipActivity() {
        pointActivites -= 1;
    }

    public int getAttack() {
        return attack;
    }

    public void increaseAttack(int value) {
        attack += value;
    }

    public void decreaseAttack(int value) {
        attack -= value;
    }


    public void setPointActivites(int value) {
        pointActivites = value;
    }

    public void addPointActivites(int value) {
        pointActivites += value;
    }
    public void decreasePointActivities(){
        pointActivites -= 1;
    }
    public void addHealth(int value) {
        health += value;
    }

    public void decreaseHealth(int value) {
        if (health - value > 0) {
            health -= value;
        } else {
            die(); // умер
        }
    }

    // реализовать смерть посредством удаления юнита из списка на "арене"
    public void die() {
        health = 0;
    }

    public void addDefence(int value) {
        defense += value;
    }

    public void decreaseDefence(int value) {
        defense -= value;
    }

    public void addSpeed(int value) {
        defense += value;
    }

    public void decreaseSpeed(int value) {
        defense -= value;
    }

    public String getUnitBaseInfo() {
        return "Тип: " + type.toString() + " Имя: " + name + " Здоровье: " + health + " Атака: " + attack;
    }

    @Override
    public String toString() {
        return getUnitBaseInfo();
    }

    @Override
    public String getInfo() {
        return this.toString();
    }


    public String getShortInfo() {
        return "Тип: " + type.toString() + " Имя: " + name + " Здоровье: " + health;
    }

    @Override
    public int step(int speed) {
        return speed -= 1;
    }

    // Все геттеры и сеттеры:
    public int getDefense() {
        return defense;
    }

    public void setAttack(int value) {
        attack = value;
    }

    public int getPointActivites() {
        return pointActivites;
    }
    public int getSpeed() {
        return speed;
    }
    public int getHealth() {
        return health;
    }
}
