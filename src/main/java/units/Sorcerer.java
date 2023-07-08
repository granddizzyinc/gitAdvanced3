package units;

import arena.Arena;
import units.abstractUnits.Equipment;
import units.abstractUnits.Unit;
import units.abstractUnits.UnitAttackingWithMagician;
import units.abstractUnits.UnitsTypes;

import java.util.Random;

public class Sorcerer extends UnitAttackingWithMagician {
    int extraActivities = 1;
    int distanceSkill = 8;
    public Sorcerer(String name) {
        super(Equipment.runes_and_powders.getHealth(), Equipment.runes_and_powders.getAttack(),
                Equipment.runes_and_powders.getDefend(), UnitsTypes.Sorcerer, name);
    }
    public void performAnAttack(Unit unit) {
        super.performAnAttack(unit);
        if (extraActivities > 0) {
            if (getAttack() - getDefense() > 0) {
                unit.decreaseHealth(getAttack() - getDefense());
            }
        }
    }
    public void tricks(Unit target){
        if (getAbilityPoints() == 2) {
            super.useAbility();
            switch (new Random().nextInt(1,3)) {
                case 1 -> target.decreaseSpeed(1);
                case 2 -> target.decreasePointActivities();
            }
        }
    }

    @Override
    public void step(int speed, Unit target) {

//        return speed -= 1;
    }

    @Override
    public Unit findTarget(Arena arena, Team ourTeam) {

        // ищем чужого с минимальным здоровьем
        return arena.findAUnitWithMinimumHealth(ourTeam, true);
    }
}
