package units;

import units.abstractUnits.UnitProtectiveWithoutShild;

/**
 * Монах
 */
public class Monk extends UnitProtectiveWithoutShild {
    public Monk(String name) {
        super(Equipment.kesa_and_beads.getHealth(), Equipment.kesa_and_beads.getAttack(),
                Equipment.kesa_and_beads.getDefend(), UnitsTypes.Monk, name);
    }
}
