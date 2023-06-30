package units.Abstract;

import units.UnitsTypes;

public abstract class UnitSupportiveBasic extends UnitSupportive {

    public UnitSupportiveBasic(UnitsTypes type, String name) {
        super(type, name);
    }

    public void putUpABarrier(Unit unit) {
        unit.decreaseAttack(5);
    }
}
