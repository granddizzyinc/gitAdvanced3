package units;

import units.Abstract.UnitProtectiveWithoutShild;

/**
 * Монах
 */
public class Monk extends UnitProtectiveWithoutShild {
    public Monk(String name) {
        super(Equipment.kesa_and_beads.getHealth(), Equipment.kesa_and_beads.getAttack(),
                Equipment.kesa_and_beads.getDefend(), UnitsTypes.Monk, name);
    }
}
