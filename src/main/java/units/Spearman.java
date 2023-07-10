package units;

import arena.Arena;
import units.abstractUnits.Equipment;
import units.abstractUnits.Unit;
import units.abstractUnits.UnitAttackingWithWeapons;
import units.abstractUnits.UnitsTypes;

/**
 * Копейщик
 */
public class Spearman extends UnitAttackingWithWeapons {
    int distanceSkill = 2;
    public Spearman(String name) {
        super(Equipment.spear_and_cuirass.getHealth(), Equipment.spear_and_cuirass.getAttack(),
                Equipment.spear_and_cuirass.getDefend(), UnitsTypes.Spearman,  name);
    }
    public void stun(Unit target){
        if (getAbilityPoints() == 2 && getPointActivites() == 1) {
            super.clearPointAbility();
            super.performAnAttack(target);
            target.clearPointActivites();
        }
    }

    @Override
    public Unit findTarget(Arena arena, Team ourTeam) {
        // ищем ближайшего чужого
        return arena.findTheNearestTeamUnit(ourTeam, this, true);
    }

    @Override
    public boolean applyAbility(Unit targetUnit) {
        System.out.print("Применяю способности: ");
        boolean res = false;
        if (!res) {
            System.out.print("Не получилось");
        }
        System.out.println();

        return res;
    }
}
