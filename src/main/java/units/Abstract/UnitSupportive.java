package units.Abstract;

import units.UnitsTypes;

public abstract class UnitSupportive extends Unit {

    private int speed;
    private int pointActivites;

    public UnitSupportive(int health, int defense, int attack, UnitsTypes type, String name) {
        super(health, defense, attack, type, name);
        pointActivites = super.getPointActivites() * 2;
    }

    public UnitSupportive(UnitsTypes type, String name) {
        this(0, 0, 0, type, name);
    }
}
