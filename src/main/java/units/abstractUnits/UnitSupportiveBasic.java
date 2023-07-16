package units.abstractUnits;

import arena.Arena;
import arena.map.Map;

public abstract class UnitSupportiveBasic extends UnitSupportive {

    public UnitSupportiveBasic(UnitsTypes type, String name) {
        this(0, 0, 0, type, name);
    }

    public UnitSupportiveBasic(int health, int defense, int attack, UnitsTypes type, String name) {
        super(health, defense, attack, type, name);
    }

    public boolean putUpABarrier(Unit unit) {  //это предварительно, а так должен появитсья объект на карте
        unit.decreaseAttack(5);
        return true;
    }
}
