package units;

import units.abstractUnits.Equipment;
import units.abstractUnits.UnitAttackingWithWeapons;
import units.abstractUnits.UnitsTypes;

/**
 * Копейщик
 */
public class Spearman extends UnitAttackingWithWeapons {
    public Spearman(String name) {
        super(Equipment.spear_and_cuirass.getHealth(), Equipment.spear_and_cuirass.getAttack(),
                Equipment.spear_and_cuirass.getDefend(), UnitsTypes.Spearman,  name);
    }
}
