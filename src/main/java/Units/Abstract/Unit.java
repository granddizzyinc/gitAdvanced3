package Units.Abstract;

import java.util.Random;

public abstract class Unit {
    private int health;
    private int pointActivites;
    private int defense;
    private int speed;


    public Unit() {
        health = 50;
        defense = 10;
        speed = 1;
        pointActivites = 100;
    }

    public void makeAMove() {

    }

    public void skipAMove() {

    }

    public int getPointActivites() {
        return health;
    }

    public void setPointActivites(int value) {
        health = value;
    }

    public void addPointActivites(int value) {
        health += value;
    }

    public void decreasePointActivites(int value) {
        health -= value;
    }

    public int getHealth() {
        return health;
    }

    public void addHealth(int value) {
        health += value;
    }

    public void decreaseHealth(int value) {
        health -= value;
    }

    public int getDefense() {
        return defense;
    }

    public void addDefence(int value) {
        defense += value;
    }

    public void decreaseDefence(int value) {
        defense -= value;
    }

    public int getSpeed() {
        return speed;
    }

    public void addSpeed(int value) {
        defense += value;
    }

    public void decreaseSpeed(int value) {
        defense -= value;
    }
}
