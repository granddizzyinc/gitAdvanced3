package units.abstractUnits;

import arena.Arena;
import units.Coordinates;
import units.Names;
import units.Palladine;
import units.UnitInterface;

import java.util.Random;

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
    private boolean done_move;
    private boolean done_attack;
    private int initiative;
    private Coordinates coordinates;

    public int distanceSkill = 1;


    public Unit(int health, int defense, int attack, UnitsTypes type, String name) {
        this.health = 50 + health;
        this.defense = 2 + defense;
        this.attack = 5 + attack;
        speed = 3;
        pointActivites = 1;
        defended = false;
        attacked = false;
        done_move = false;
        done_attack = false;
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
        //атакуем
        //* Ближники (не дальше 1 клетки)
        //* Дальники (5 клеток - 100% урон, до 7 клеток - 75% урона, до 9 клеток - 50%, 10 и более - не может атаковать)

        System.out.println("Атакую: " + target);

        if (getPointActivites() > 0) {
            if (this.attack - target.getDefense() > 0) {
                target.decreaseHealth(this.attack - target.getDefense());
                decreasePointActivities();
            } else {
                System.out.println("Не прокатило");
            }
        } else {
            System.out.println("Нет очков активности");
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

    public void decreasePointActivities() {
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

    public void increaseDefence(int value) {
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

//    @Override
//    public int step(int speed, Unit target) {
//        return speed -= 1;
//    }

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

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public int getSpeed() {
        return speed;
    }

    public int getHealth() {
        return health;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    public static String getRandomUnitName() {
        return Names.values()[new Random().nextInt(Names.values().length)].toString();
    }

    @Override
    public void step(Arena arena) {
//        Unit targetUnit = findTarget(arena, arena.getUnitTeam(this));
//
//        if (targetUnit == null) {
//            System.out.println("Цель: не найдена");
//        } else {
//            System.out.println("Цель: " + targetUnit + " " + targetUnit.getCoordinates());
//        }
    }
}
