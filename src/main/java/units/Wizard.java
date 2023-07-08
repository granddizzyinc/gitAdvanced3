package units;

import arena.Arena;
import units.abstractUnits.Equipment;
import units.abstractUnits.Unit;
import units.abstractUnits.UnitAttackingWithMagician;
import units.abstractUnits.UnitsTypes;

/**
 * Маг
 */
public class Wizard extends UnitAttackingWithMagician {
    int distanceSkill = 9;

    public Wizard(String name) {
        super(Equipment.mantle_and_wand.getHealth(), Equipment.mantle_and_wand.getAttack(),
                Equipment.mantle_and_wand.getDefend(), UnitsTypes.Wizard, name);
    }

    @Override
    public void step(int speed, Unit target, Arena arena, Coordinates stepCoordinates) {
        this.setCoordinates(stepCoordinates);
    }

    @Override
    public Unit findTarget(Arena arena, Team ourTeam) {

        // ищем чужого с минимальным здоровьем
        return arena.findAUnitWithMinimumHealth(ourTeam, true);
    }
}
