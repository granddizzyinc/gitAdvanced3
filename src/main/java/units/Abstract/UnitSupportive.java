package units.Abstract;

import units.UnitsTypes;

public abstract class UnitSupportive extends Unit {

    private int speed;
    private int pointActivites;

    public UnitSupportive(UnitsTypes type, String name) {
        super(type, name);
//        speed = super.getSpeed() * 2;
        pointActivites = super.getPointActivites() * 2;
    }
}
