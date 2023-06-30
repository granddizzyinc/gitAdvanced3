package units;

import units.Abstract.Unit;
import units.Abstract.UnitAttackingWithWeapons;

import java.util.EnumSet;

/**
 * Арбалетчик
 */
public class Crossbowman extends UnitAttackingWithWeapons {
    Equipment crossbow_and_helmet = Equipment.crossbow_and_helmet;
    int extraHealth = crossbow_and_helmet.getHealth();
    int extraAttack = crossbow_and_helmet.getAttack();
    int extraDefence = crossbow_and_helmet.getDefend();
    public Crossbowman(String name) {
        super(extraHealth, extraAttack, extraDefence, UnitsTypes.Crossbowman, name);

    }

    @Override
    public void performAnAttack(Unit unit) {
        super.performAnAttack(unit);

    }



}
