package units.Abstract;

import units.UnitsTypes;

public abstract class UnitSupportiveHealer extends UnitSupportive {


    public UnitSupportiveHealer(UnitsTypes type, String name) {
        super(type, name);
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
