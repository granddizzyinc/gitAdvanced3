package units;

import units.abstractUnits.Equipment;
import units.abstractUnits.Unit;
import units.abstractUnits.UnitProtectiveWithoutShild;
import units.abstractUnits.UnitsTypes;

/**
 * Монах
 */
public class Monk extends UnitProtectiveWithoutShild {
    public Monk(String name) {
        super(Equipment.kesa_and_beads.getHealth(), Equipment.kesa_and_beads.getAttack(),
                Equipment.kesa_and_beads.getDefend(), UnitsTypes.Monk, name);
    }
    public void defenceCape(Unit target){
        if (getAbilityPoints() == 2) {
            super.useAbility();
            super.decreaseDamage(target.getDefense()*1);   // вот здесь как-то определить тип атаки
        }
    }
}
