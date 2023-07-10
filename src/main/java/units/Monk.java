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
    int distanceSkill = 9;

    public Monk(String name) {
        super(Equipment.kesa_and_beads.getHealth(), Equipment.kesa_and_beads.getAttack(),
                Equipment.kesa_and_beads.getDefend(), UnitsTypes.Monk, name);
    }

    public boolean defenceCape(Unit target) {
        if (getAbilityPoints() == 2) {
            System.out.println("Мыс обороны");
            super.clearAbilityPoints();
            super.decreaseDamage(target.getDefense() * 1);   // вот здесь как-то определить тип атаки
            return true;
        }
        return false;
    }

    @Override
    public Unit findTarget(Arena arena, Team ourTeam) {
        // ищем своего с минимальным здоровьем
        return arena.findAUnitWithMinimumHealth(ourTeam, this, false);
    }

    @Override
    public boolean applyAbility(Unit targetUnit) {
        return defenceCape(targetUnit);
    }
}
