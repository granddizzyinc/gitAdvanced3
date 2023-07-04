package units.abstractUnits;

import units.UnitsTypes;

public abstract class UnitSupportiveBasic extends UnitSupportive {

    public UnitSupportiveBasic(UnitsTypes type, String name) {
        this(0, 0, 0, type, name);
    }

    public UnitSupportiveBasic(int health, int defense, int attack, UnitsTypes type, String name) {
        super(health, defense, attack, type, name);
    }

    public void putUpABarrier(Unit unit) {
        unit.decreaseAttack(5);
    }
}
