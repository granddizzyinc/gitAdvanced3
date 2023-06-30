package units;

import units.Abstract.Unit;
import units.Abstract.UnitAttackingWithWeapons;

import java.util.EnumSet;

/**
 * Арбалетчик
 */
public class Crossbowman extends UnitAttackingWithWeapons {

    public Crossbowman(String name) {
        super(UnitsTypes.Crossbowman, name);
    }

    @Override
    public void performAnAttack(Unit unit) {
        super.performAnAttack(unit);

    }



}
