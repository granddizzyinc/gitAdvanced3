package units;

import arena.Arena;
import units.abstractUnits.Equipment;
import units.abstractUnits.Unit;
import units.abstractUnits.UnitAttackingWithWeapons;
import units.abstractUnits.UnitsTypes;


/**
 * Арбалетчик
 */
public class Crossbowman extends UnitAttackingWithWeapons {
    // переопределить очки активности??
    int extraActivities = 1;
    int distanceSkill = 9;
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
    public void arrow_to_the_knee(Unit unit){
        if (getAbilityPoints() == 2) {
            super.useAbility();
            decreaseSpeed(1);
        }
    }

    @Override
    public void step(int speed, Unit target) {

    }

    @Override
    public Unit findTarget(Arena arena, Team ourTeam) {

        // ищем чужого с минимальным здоровьем
        return arena.findAUnitWithMinimumHealth(ourTeam, true);
    }
}
