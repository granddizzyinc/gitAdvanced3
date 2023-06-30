package units;

import units.Abstract.UnitAttackingWithMagician;

/**
 * Маг
 */
public class Wizard extends UnitAttackingWithMagician {
    public Wizard(String name) {
        super(Equipment.mantle_and_wand.getHealth(), Equipment.mantle_and_wand.getAttack(), Equipment.mantle_and_wand.getDefend(), UnitsTypes.Wizard, name);
    }
}
