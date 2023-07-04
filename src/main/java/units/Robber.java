package units;

import units.abstractUnits.Equipment;
import units.abstractUnits.Unit;
import units.abstractUnits.UnitAttackingWithWeapons;
import units.abstractUnits.UnitsTypes;

/**
 * Разбойник
 */
public class Robber extends UnitAttackingWithWeapons {
    public Robber(String name) {
        super(Equipment.knives_and_cloak.getHealth(), Equipment.knives_and_cloak.getAttack(),
                Equipment.knives_and_cloak.getDefend(), UnitsTypes.Robber, name);
    }
    public void theft(Unit target){
        if (getAbilityPoints() == 2) {
            super.useAbility();
            for (int i = 0; i < 2; i++) {
                target.decreasePointActivities();
            }
        }
    }
    public void jab(Unit target){
        if (getAbilityPoints() == 2){
            super.useAbility();
            target.decreasePointActivities();
            target.decreaseHealth(10);
        }
    }
}
