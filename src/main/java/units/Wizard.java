package units;

import units.Abstract.UnitAttackingWithMagician;

/**
 * Маг
 */
public class Wizard extends UnitAttackingWithMagician {

    public Wizard(String name) {
        super(UnitsTypes.Wizard, name);
    }
}
