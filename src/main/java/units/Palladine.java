package units;

import units.abstractUnits.Equipment;
import units.abstractUnits.UnitProtectiveWithShield;
import units.abstractUnits.UnitsTypes;

/**
 * Палладин
 */
public class Palladine extends UnitProtectiveWithShield {

    public Palladine(String name) {
        super(Equipment.shield_and_sword.getHealth(), Equipment.shield_and_sword.getAttack(),
                Equipment.shield_and_sword.getDefend(), UnitsTypes.Palladine, name);
    }
}
