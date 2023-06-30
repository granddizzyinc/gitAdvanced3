package units.Abstract;

import units.UnitsTypes;

public abstract class UnitSupportiveHealer extends UnitSupportive {


    public UnitSupportiveHealer(UnitsTypes type, String name) {
        this(0,0,0,type, name);
    }

    public UnitSupportiveHealer(int health, int defense, int attack, UnitsTypes type, String name) {
        super(health, defense, attack, type, name);
    }

    /**
     * лечить
     *
     * @param unit
     */
    public void smallHeal(Unit unit) {
        unit.addHealth(10);
    }
}
