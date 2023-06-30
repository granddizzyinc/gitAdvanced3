package units;

import units.Abstract.UnitAttackingWithWeapons;

/**
 * Разбойник
 */
public class Robber extends UnitAttackingWithWeapons {

    public Robber(String name) {
        super(UnitsTypes.Robber, name);
    }
}
