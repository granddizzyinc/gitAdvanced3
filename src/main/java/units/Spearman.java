package units;

import units.Abstract.UnitAttackingWithWeapons;

/**
 * Копейщик
 */
public class Spearman extends UnitAttackingWithWeapons {

    public Spearman(String name) {
        super(UnitsTypes.Spearman,  name);
    }
}
