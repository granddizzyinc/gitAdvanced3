package units;

import units.Abstract.Unit;
import units.Abstract.UnitAttackingWithWeapons;

import java.util.EnumSet;

/**
 * Арбалетчик
 */
public class Crossbowman extends UnitAttackingWithWeapons {

    public Crossbowman(String name) {
        super(Equipment.crossbow_and_helmet.getHealth(), Equipment.crossbow_and_helmet.getAttack(), Equipment.crossbow_and_helmet.getDefend(), UnitsTypes.Crossbowman, name);

    }

    @Override
    public void performAnAttack(Unit unit) {
        super.performAnAttack(unit);

    }



}
