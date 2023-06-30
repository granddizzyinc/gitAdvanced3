package units;

import units.Abstract.UnitAttackingWithWeapons;

/**
 * Снайпер
 */
public class Sniper extends UnitAttackingWithWeapons {

    public Sniper(String name) {
        super(UnitsTypes.Sniper, name);
    }
}
