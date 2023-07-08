package units;

import arena.Arena;
import units.abstractUnits.Equipment;
import units.abstractUnits.Unit;
import units.abstractUnits.UnitAttackingWithWeapons;
import units.abstractUnits.UnitsTypes;

/**
 * Снайпер
 */
public class Sniper extends UnitAttackingWithWeapons {
    int distanceSkill = 9;
    private boolean using_Hit_the_bulls_eye = false;
    public Sniper(String name) {
        super(Equipment.bow_and_arrows.getHealth(), Equipment.bow_and_arrows.getAttack(),
                Equipment.bow_and_arrows.getDefend(), UnitsTypes.Sniper, name);
    }
    public void Hit_the_bulls_eye(Unit target){
        if (getAbilityPoints() == 2){
            if (using_Hit_the_bulls_eye == false) {
                super.useAbility();
                target.decreaseHealth(getHealth()/2);
                using_Hit_the_bulls_eye = true;
            }
        }
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
