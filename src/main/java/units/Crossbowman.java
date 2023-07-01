package units;

import units.abstractUnits.Unit;
import units.abstractUnits.UnitAttackingWithWeapons;

/**
 * Арбалетчик
 */
public class Crossbowman extends UnitAttackingWithWeapons {
    // переопределить очки активности??
    int extraActivities = 1;
    public Crossbowman(String name) {
        super(Equipment.crossbow_and_helmet.getHealth(), Equipment.crossbow_and_helmet.getAttack(),
                Equipment.crossbow_and_helmet.getDefend(), UnitsTypes.Crossbowman, name);

    }

    @Override
    public void performAnAttack(Unit unit) {
        super.performAnAttack(unit);
        if (extraActivities > 0) {
            if (getAttack() - getDefense() > 0) {
                unit.decreaseHealth(getAttack() - getDefense());
            }
        }
    }
}
