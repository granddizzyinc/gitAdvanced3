package units;

import arena.Arena;
import units.abstractUnits.Equipment;
import units.abstractUnits.Unit;
import units.abstractUnits.UnitProtectiveWithoutShild;
import units.abstractUnits.UnitsTypes;

/**
 * Монах
 */
public class Monk extends UnitProtectiveWithoutShild {
    public final int distanceSkill = 9;

    public Monk(String name) {
        super(Equipment.kesa_and_beads.getHealth(), Equipment.kesa_and_beads.getAttack(),
                Equipment.kesa_and_beads.getDefend(), UnitsTypes.Monk, name);
    }

    /**
     * Мысли монаха
     * @param target
     * @return
     */
    public boolean mindMonk(Unit target) {
        if (getAbilityPoints() == 2) {
            super.clearAbilityPoints();
            //super.decreaseDamage(target.getDefense() * 1);   // вот здесь как-то определить тип атаки

            target.addSuperimposedAction("Мысли монаха", 2,0, target.getDefense(), 0);
            return true;
        }
        return false;
    }

    @Override
    public Unit findTarget(Arena arena) {
        // ищем своего с минимальным здоровьем
        return arena.findAUnitWithMinimumHealth(this, false);
    }

    @Override
    public boolean applyAbility(Unit targetUnit) {
        return mindMonk(targetUnit);
    }

//    @Override
//    public void restoringParameters() {
//        super.restoringParameters(Unit.baseAtack + Equipment.kesa_and_beads.getAttack(), Unit.baseDefence + Equipment.kesa_and_beads.getDefend());
//    }
}
