package units;

import units.Abstract.UnitProtectiveWithoutShild;

/**
 * Монах
 */
public class Monk extends UnitProtectiveWithoutShild {
    Equipment kesa_and_beads = Equipment.kesa_and_beads;
    int extraHealth = kesa_and_beads.getHealth();
    int extraAttack = kesa_and_beads.getAttack();
    int extraDefence = kesa_and_beads.getDefend();
    public Monk(String name) {
        super(UnitsTypes.Monk, name);
    }
}
